import { LugarService } from './../../../servicios/lugar.service';
import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { LoadingController, ToastController } from '@ionic/angular';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Lugar } from 'src/app/dominio/lugar';
import { Usuario } from 'src/app/dominio/usuario';
import { SeguridadService } from 'src/app/servicios/seguridad.service';

@Component({
  selector: 'app-agregar-lugar',
  templateUrl: './agregar-lugar.page.html',
  styleUrls: ['./agregar-lugar.page.scss'],
})
export class AgregarLugarPage implements OnInit {

  formularioAgregarLugar: FormGroup;
  enviado = false;
  carga: any;

  constructor(private fb: FormBuilder, private location: Location, private toastController: ToastController,
    public loadingController: LoadingController, private lugarServicio: LugarService,
    private seguridadService: SeguridadService) { }

  ngOnInit() {
    this.formularioAgregarLugar = this.fb.group({
      nombre: [null, [Validators.required]],
      ubicacion: [null, [Validators.required]]
    });
  }


  agregar() {
    this.enviado = true;
    if (this.formularioAgregarLugar.invalid) {
      return null;
    }
    this.mostrarCarga().then(_ => {
      const lugar = new Lugar();
      lugar.nombre = this.f.nombre.value;
      lugar.ubicacion = this.f.ubicacion.value;
      lugar.usuario = new Usuario();
      lugar.usuario.cedula = this.seguridadService.obtenerDocumentoUsuario();
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

  get f() { return this.formularioAgregarLugar.controls; }

}
