import { AnalisisService } from './../../../servicios/analisis.service';
import { ModalAgregarAnalisisComponent } from './../modal-agregar-analisis-component/modal-agregar-analisis-component.component';
import { Unidad } from './../../../dominio/unidad';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { LoadingController, ModalController, ToastController } from '@ionic/angular';
import { ParcelaService } from 'src/app/servicios/parcela.service';
import { Parcela } from 'src/app/dominio/parcela';
import { DTOElementoXAnalisis } from 'src/app/dto/dto-elemento';
import { Location } from '@angular/common';
import { DTOAnalisis } from 'src/app/dto/dto-analisis';

@Component({
  selector: 'app-agregar-analisis',
  templateUrl: './agregar-analisis.page.html',
  styleUrls: ['./agregar-analisis.page.scss'],
})
export class AgregarAnalisisPage implements OnInit {

  formularioAgregarAnalisis: FormGroup;
  enviado = false;
  mostrarErrorElemento = false;
  carga: any;
  parcelas: Parcela[];
  unidades: Unidad[];
  elementosXAnalisis: DTOElementoXAnalisis[] = [];
  fechaMaximaAnalisis: string;

  constructor(private fb: FormBuilder, private location: Location, public loadingController: LoadingController,
    private parcelaServicio: ParcelaService, private analisisServicio: AnalisisService,
    private modalController: ModalController, private toastController: ToastController) { }

  ngOnInit() {
    this.fechaMaximaAnalisis = new Date().toISOString();
    this.formularioAgregarAnalisis = this.fb.group({
      parcela: [null, Validators.required],
      fechaAnalisis: [null, [Validators.required]],
      elemento: [null],
    });
    this.parcelaServicio.geBackParcelas().subscribe(parcelas => {
      this.parcelas = parcelas;
    });
  }

  async abrirModalAgregarElemento() {
    const modal = await this.modalController.create({
      component: ModalAgregarAnalisisComponent,
      componentProps: { elementosXAnalisis: this.elementosXAnalisis },
    });

    modal.onDidDismiss().then((data: any) => {
      const elementoPorAnalisis = data.data.resultado as DTOElementoXAnalisis;
      if (!!elementoPorAnalisis) {
        this.elementosXAnalisis.push(elementoPorAnalisis);
      }
      this.f.elemento.setValue(null);
    });

    return await modal.present();
  }

  agregar() {
    this.enviado = true;
    this.mostrarErrorElemento = this.elementosXAnalisis.length < 1;
    if (this.formularioAgregarAnalisis.invalid || this.elementosXAnalisis.length < 1) {
      return null;
    }
    this.mostrarCarga().then(_ => {
      const analisis = new DTOAnalisis();
      analisis.elementos = this.elementosXAnalisis;
      analisis.fechaAnalisis = this.f.fechaAnalisis.value;
      analisis.parcela = this.f.parcela.value;
      this.analisisServicio.updateOrCreate(analisis).subscribe(
        resp => {
          this.mostrarToast('Éxito registrando análisis');
          this.analisisServicio.geBackAnalisis();
          this.location.back();
        },
        error => {
          this.mostrarToast('Error registrando análisis');
        }
      );
      this.ocultarCarga();
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

  eliminarElementoPorAnalisis(elementoPorAnalisis: DTOElementoXAnalisis) {
    const index: number = this.elementosXAnalisis.indexOf(elementoPorAnalisis);
    this.elementosXAnalisis.splice(index, 1);
  }

  get f() { return this.formularioAgregarAnalisis.controls; }

}
