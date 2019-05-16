import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Lugar } from 'src/app/dominio/lugar';
import { TipoCultivo } from 'src/app/dominio/tipo-cultivo';
import { LugarService } from 'src/app/servicios/lugar.service';
import { LoadingController, ToastController } from '@ionic/angular';
import { ParcelaService } from 'src/app/servicios/parcela.service';
import { TipoCultivoService } from 'src/app/servicios/tipo-cultivo.service';
import { Parcela } from 'src/app/dominio/parcela';
import { Location } from '@angular/common';

@Component({
  selector: 'app-editar-parcela',
  templateUrl: './editar-parcela.page.html',
  styleUrls: ['./editar-parcela.page.scss'],
})
export class EditarParcelaPage implements OnInit {

  formularioEditarParcela: FormGroup;
  enviado = false;
  carga: any;
  lugares: Lugar[];
  tiposCultivo: TipoCultivo[];
  parcelaSubject: Parcela;
  fechaMaximaSiembra: string;

  constructor(private fb: FormBuilder, private location: Location, private lugarServicio: LugarService,
    public loadingController: LoadingController, private parcelaServicio: ParcelaService,
    private tipoCultivoServicio: TipoCultivoService, private toastController: ToastController) { }

  ngOnInit() {
    this.fechaMaximaSiembra = new Date().toISOString();
    this.formularioEditarParcela = this.fb.group({
      lugar: [null, Validators.required],
      tipoCultivo: [null, Validators.required],
      area: [null, [Validators.required]],
      fechaSiembra: [null, [Validators.required]],
    });
    this.lugarServicio.geBackLugares().subscribe(lugares => {
      this.lugares = lugares;
    });
    this.tipoCultivoServicio.geBackTiposCultivo().subscribe(tipoCultivo => {
      this.tiposCultivo = tipoCultivo;
    });
    this.cargarParcela();
  }

  private cargarParcela() {
    this.parcelaServicio.getParcela().subscribe(result => {
      this.parcelaSubject = result;
      this.f.lugar.setValue(result.lugar.codigoLugar);
      this.f.tipoCultivo.setValue(result.tipoCultivo.codigoTipoCultivo);
      this.f.area.setValue(result.area);
      this.f.fechaSiembra.setValue(result.fechaSiembra);
    });
  }

  editar() {
    this.enviado = true;
    if (this.formularioEditarParcela.invalid) {
      return null;
    }
    this.mostrarCarga().then(_ => {
      this.parcelaSubject.lugar = this.lugares.find(
        lugar => lugar.codigoLugar === this.f.lugar.value);
      this.parcelaSubject.tipoCultivo = this.tiposCultivo.find(
        tipoCultivo => tipoCultivo.codigoTipoCultivo === this.f.tipoCultivo.value);
      this.parcelaSubject.area = this.f.area.value;
      this.parcelaSubject.fechaSiembra = this.f.fechaSiembra.value;
      this.parcelaServicio.updateOrCreate(this.parcelaSubject).subscribe(
        resp => {
          this.mostrarToast('Éxito registrando parcela');
          this.parcelaServicio.cargarDatos();
          this.location.back();
          this.ocultarCarga();
        },
        error => {
          this.mostrarToast('Error registrando parcela');
        }
      );
    });
  }

  async mostrarToast(mensaje: string) {
    const toast = await this.toastController.create({
      message: mensaje,
      duration: 2000
    });
    toast.present();
  }

  async mostrarCarga() {
    this.carga = await this.loadingController.create({
      message: 'Agregando...'
    });
    return this.carga.present();
  }

  ocultarCarga() {
    this.carga.dismiss();
  }

  get f() { return this.formularioEditarParcela.controls; }

}
