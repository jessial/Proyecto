import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoadingController, ToastController } from '@ionic/angular';
import { SeguridadService } from 'src/app/servicios/seguridad.service';

@Component({
  selector: 'app-olvido-password',
  templateUrl: './olvido-password.page.html',
  styleUrls: ['./olvido-password.page.scss'],
})
export class OlvidoPasswordPage implements OnInit {

  enviado = false;
  formularioRecuperacion: FormGroup;
  carga: any;

  constructor(private fb: FormBuilder, private router: Router, private seguridadService: SeguridadService,
    private toastController: ToastController, private loadingController: LoadingController) { }

  ngOnInit() {
    this.formularioRecuperacion = this.fb.group({
      documento: [null, [Validators.required]]
    });
  }

  recuperarContrasena() {
    this.enviado = true;
    if (this.formularioRecuperacion.invalid) {
      return null;
    }
    this.mostrarCarga().then(_ => {
      this.seguridadService.recuperarPassword(this.f.documento.value).subscribe(succ => {
        this.mostrarToast('Contraseña enviada.');
        this.ocultarCarga();
      }, err => {
        this.mostrarToast(err.error.message);
        this.ocultarCarga();
      });
    });
  }

  async mostrarToast(mensaje: string) {
    const toast = await this.toastController.create({
      message: mensaje,
      duration: 4000
    });
    toast.present();
  }

  async mostrarCarga() {
    this.carga = await this.loadingController.create({
      message: 'Recuperando contraseña...'
    });
    return this.carga.present();
  }

  get f() { return this.formularioRecuperacion.controls; }

  redireccionRegistrarUsuario() {
    this.router.navigateByUrl('registro-usuario');
  }

  ocultarCarga() {
    this.carga.dismiss();
  }
}
