import { Component, OnInit } from '@angular/core';
import { LugarService } from './../../../servicios/lugar.service';
import { Location } from '@angular/common';
import { LoadingController, ToastController } from '@ionic/angular';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Lugar } from 'src/app/dominio/lugar';

@Component({
  selector: 'app-editar-lugar',
  templateUrl: './editar-lugar.page.html',
  styleUrls: ['./editar-lugar.page.scss'],
})
export class EditarLugarPage implements OnInit {

  formularioEditarLugar: FormGroup;
  enviado = false;
  carga: any;
  lugarSubject: Lugar;

  constructor(private fb: FormBuilder, private location: Location, private toastController: ToastController,
    public loadingController: LoadingController, private lugarServicio: LugarService) { }

  ngOnInit() {
    this.formularioEditarLugar = this.fb.group({
      nombre: [null, [Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
      ubicacion: [null, [Validators.required, Validators.minLength(3), Validators.maxLength(20)]]
    });
    this.cargarLugar();
  }

  private cargarLugar() {
    this.lugarServicio.getLugar()
      .subscribe(result => {
        this.lugarSubject = result;
        this.f.nombre.setValue(result.nombre);
        this.f.ubicacion.setValue(result.ubicacion);
      }
      );
  }


  editar() {
    this.enviado = true;
    if (this.formularioEditarLugar.invalid) {
      return null;
    }
    this.mostrarCarga().then(_ => {
      this.lugarSubject.nombre = this.f.nombre.value;
      this.lugarSubject.ubicacion = this.f.ubicacion.value;
      this.lugarServicio.updateOrCreate(this.lugarSubject).subscribe(
        resp => {
          this.lugarServicio.cargarDatos();
          this.location.back();
          this.mostrarToast('Éxito registrando finca');
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
      message: 'Editando...'
    });
    return this.carga.present();
  }

  ocultarCarga() {
    this.carga.dismiss();
  }

  get f() { return this.formularioEditarLugar.controls; }

}
