import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { LoadingController, ToastController } from '@ionic/angular';
import { Fuente } from 'src/app/dominio/fuente';
import { DTOAnalisis } from 'src/app/dto/dto-analisis';
import { FuenteParaRecomendacion } from 'src/app/dto/fuente-para-recomendacion';
import { AnalisisService } from 'src/app/servicios/analisis.service';
import { RecomendacionService } from 'src/app/servicios/recomendacion.service';
import { FuenteService } from './../../../servicios/fuente.service';

@Component({
  selector: 'app-generar-recomendacion',
  templateUrl: './generar-recomendacion.page.html',
  styleUrls: ['./generar-recomendacion.page.scss'],
})
export class GenerarRecomendacionPage implements OnInit {

  formularioGenerarRecomendacion: FormGroup;
  enviado = false;
  carga: any;
  analisis: DTOAnalisis;
  mostrarMensajeError = false;
  listaFuentesPotasio: Fuente[] = [];
  listaFuentesFosforo: Fuente[] = [];
  listaFuentesNitrogeno: Fuente[] = [];

  constructor(private fb: FormBuilder, private toastController: ToastController,
    public loadingController: LoadingController, private fuenteServicio: FuenteService,
    private analisisServicio: AnalisisService, private recomendacionServicio: RecomendacionService,
    private location: Location) { }

  ngOnInit() {
    this.analisis = this.analisisServicio.getDetalleAnalisis();
    this.formularioGenerarRecomendacion = this.fb.group({
      potasio: [null],
      fosforo: [null],
      nitrogeno: [null]
    });
    this.fuenteServicio.cargarDatosFuenteFosforo();
    this.fuenteServicio.getFuentesFosforo().subscribe(fuentesFosforo => {
      this.listaFuentesFosforo = fuentesFosforo;
    });

    this.fuenteServicio.cargarDatosFuenteNitrogeno();
    this.fuenteServicio.getFuentesNitrogeno().subscribe(fuentesNitrogeno => {
      this.listaFuentesNitrogeno = fuentesNitrogeno;
    });

    this.fuenteServicio.cargarDatosFuentePotasio();
    this.fuenteServicio.getFuentesPotasio().subscribe(fuentesPotasio => {
      this.listaFuentesPotasio = fuentesPotasio;
    });
  }

  agregar() {
    this.enviado = true;
    if (!this.f.potasio.value && !this.f.fosforo.value && !this.f.nitrogeno.value) {
      this.mostrarMensajeError = true;
      return null;
    }
    this.mostrarMensajeError = false;
    const fuente = new FuenteParaRecomendacion();
    fuente.dtoAnalisis = this.analisis;
    fuente.fosforo = this.f.fosforo.value;
    fuente.nitrogeno = this.f.nitrogeno.value;
    fuente.potasio = this.f.potasio.value;
    this.mostrarCarga().then(_ => {
      this.recomendacionServicio.generarRecomendacion(fuente).subscribe(
        resp => {
          this.mostrarToast('Éxito generando recomendación');
          this.recomendacionServicio.cargarDatos(this.analisisServicio.getDetalleAnalisis().codigoAnalisis);
          this.location.back();
          this.ocultarCarga();
        },
        error => {
          this.mostrarToast('Error generando recomendación');
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

  get f() { return this.formularioGenerarRecomendacion.controls; }


}
