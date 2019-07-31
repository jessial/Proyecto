import { TipoCultivo } from './../../../dominio/tipo-cultivo';
import { LugarService } from './../../../servicios/lugar.service';
import { Lugar } from 'src/app/dominio/lugar';
import { Parcela } from 'src/app/dominio/parcela';
import { ParcelaService } from 'src/app/servicios/parcela.service';
import { LoadingController, ToastController } from '@ionic/angular';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { TipoCultivoService } from 'src/app/servicios/tipo-cultivo.service';

@Component({
  selector: 'app-agregar-parcela',
  templateUrl: './agregar-parcela.page.html',
  styleUrls: ['./agregar-parcela.page.scss'],
})
export class AgregarParcelaPage implements OnInit {

  formularioAgregarParcela: FormGroup;
  enviado = false;
  carga: any;
  lugares: Lugar[];
  tiposCultivo: TipoCultivo[];
  fechaMaximaSiembra: string;

  constructor(private fb: FormBuilder, private location: Location, private lugarServicio: LugarService,
    public loadingController: LoadingController, private parcelaServicio: ParcelaService,
    private tipoCultivoServicio: TipoCultivoService, private toastController: ToastController) { }

  ngOnInit() {
    this.fechaMaximaSiembra = new Date().toISOString();
    this.formularioAgregarParcela = this.fb.group({
      lugar: [null, Validators.required],
      tipoCultivo: [null, Validators.required],
      area: [null, [Validators.required, Validators.min(1), Validators.max(999999999)]],
      fechaSiembra: [null, [Validators.required]],
    });
    this.lugarServicio.geBackLugares().subscribe(lugares => {
      this.lugares = lugares;
    });
    this.tipoCultivoServicio.geBackTiposCultivo().subscribe(tipoCultivo => {
      this.tiposCultivo = tipoCultivo;
    });
  }


  agregar() {
    this.enviado = true;
    if (this.formularioAgregarParcela.invalid) {
      return null;
    }
    this.mostrarCarga().then(_ => {
      const parcela = new Parcela();
      parcela.lugar = this.f.lugar.value;
      parcela.tipoCultivo = this.f.tipoCultivo.value;
      parcela.area = this.f.area.value;
      parcela.fechaSiembra = this.f.fechaSiembra.value;
      this.parcelaServicio.updateOrCreate(parcela).subscribe(
        resp => {
          this.mostrarToast('Éxito registrando parcela');
          this.parcelaServicio.cargarDatos();
          this.location.back();
          this.ocultarCarga();
        },
        error => {
          this.mostrarToast('Éxito registrando parcela');
          this.ocultarCarga();
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

  get f() { return this.formularioAgregarParcela.controls; }


}
