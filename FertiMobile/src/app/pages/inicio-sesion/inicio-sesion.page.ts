import { UsuarioSeguridad } from './../../dominio/usuario-seguridad';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { ToastController } from '@ionic/angular';

@Component({
  selector: 'app-inicio-sesion',
  templateUrl: './inicio-sesion.page.html',
  styleUrls: ['./inicio-sesion.page.scss'],
})
export class InicioSesionPage implements OnInit {

  enviado = false;
  formularioInicioSesion: FormGroup;

  constructor(private fb: FormBuilder, private router: Router, private toastController: ToastController) { }

  ngOnInit() {
    this.formularioInicioSesion = this.fb.group({
      nombreUsuario: [null, [Validators.required]],
      password: [null, [Validators.required]]
    });
  }

  iniciarSesion() {
    this.enviado = true;
    if (this.f.invalid) {
      return null;
    }
    const usuario = new UsuarioSeguridad();
    usuario.nombreUsuario = this.f.nombreUsuario.value;
    usuario.password = this.f.password.value;
    // TODO: Consumir servicio incio de sesión...
    console.log(usuario);
    if (usuario.nombreUsuario === 'admin' && usuario.password === 'admin') {
      this.router.navigateByUrl('home');
    } else {
      this.presentToast();
    }
  }

  async presentToast() {
    const toast = await this.toastController.create({
      message: 'Usuario o contraseña incorrectos.',
      duration: 2000
    });
    toast.present();
  }

  get f() { return this.formularioInicioSesion.controls; }

  redireccionRegistrarUsuario() {
    this.router.navigateByUrl('registro-usuario');
  }

}
