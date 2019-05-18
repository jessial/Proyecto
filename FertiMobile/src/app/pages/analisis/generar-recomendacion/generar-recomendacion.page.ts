import { FuenteService } from './../../../servicios/fuente.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ToastController, LoadingController } from '@ionic/angular';
import { Fuente } from 'src/app/dominio/fuente';

@Component({
  selector: 'app-generar-recomendacion',
  templateUrl: './generar-recomendacion.page.html',
  styleUrls: ['./generar-recomendacion.page.scss'],
})
export class GenerarRecomendacionPage implements OnInit {

  formularioGenerarRecomendacion: FormGroup;
  enviado = false;
  carga: any;
  listaFuentesPotasio: Fuente[] = [];
  listaFuentesFosforo: Fuente[] = [];
  listaFuentesNitrogeno: Fuente[] = [];

  constructor(private fb: FormBuilder, private toastController: ToastController,
    public loadingController: LoadingController, private fuenteServicio: FuenteService) { }

  ngOnInit() {
    this.formularioGenerarRecomendacion = this.fb.group({
      potasio: [null, [Validators.required]],
      fosforo: [null, [Validators.required]],
      nitrogeno: [null, [Validators.required]]
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
    if (this.formularioGenerarRecomendacion.invalid) {
      return null;
    }
    /*
    this.mostrarCarga().then(_ => {
      this.lugarServicio.updateOrCreate(lugar).subscribe(
        resp => {
          this.mostrarToast('Éxito registrando finca');
          this.lugarServicio.cargarDatos();
          this.location.back();
          this.ocultarCarga();
        },
        error => {
          this.mostrarToast('Error registrando finca');
        }
      );
    });*/
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
