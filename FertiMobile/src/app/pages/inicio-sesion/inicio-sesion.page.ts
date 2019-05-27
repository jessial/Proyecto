import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MenuController, NavController, ToastController } from '@ionic/angular';
import { UsuarioSeguridad } from './../../dominio/usuario-seguridad';

@Component({
  selector: 'app-inicio-sesion',
  templateUrl: './inicio-sesion.page.html',
  styleUrls: ['./inicio-sesion.page.scss'],
})
export class InicioSesionPage implements OnInit {

  enviado = false;
  formularioInicioSesion: FormGroup;

  constructor(private fb: FormBuilder, private router: Router, private navCtrl: NavController,
    private menu: MenuController, private toastController: ToastController) {
    this.menu.enable(false);
  }

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
    if (usuario.nombreUsuario === 'admin' && usuario.password === 'admin') {
      this.menu.enable(true);
      this.navCtrl.navigateRoot('home');
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
