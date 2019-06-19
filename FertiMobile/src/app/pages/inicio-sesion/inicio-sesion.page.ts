import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MenuController, NavController, ToastController, LoadingController } from '@ionic/angular';
import { UsuarioSeguridad } from './../../dominio/usuario-seguridad';
import { SeguridadService } from './../../servicios/seguridad.service';

@Component({
  selector: 'app-inicio-sesion',
  templateUrl: './inicio-sesion.page.html',
  styleUrls: ['./inicio-sesion.page.scss'],
})
export class InicioSesionPage implements OnInit {

  enviado = false;
  formularioInicioSesion: FormGroup;
  carga: any;

  constructor(private fb: FormBuilder, private router: Router, private navCtrl: NavController,
    private menu: MenuController, private seguridadService: SeguridadService,
    private toastController: ToastController, private loadingController: LoadingController) {
    this.menu.enable(false);
  }

  ngOnInit() {
    this.formularioInicioSesion = this.fb.group({
      nombreUsuario: [null, [Validators.required]],
      password: [null, [Validators.required]]
    });
  }

  iniciarSesion() {
    this.seguridadService.logout();
    this.enviado = true;
    if (this.formularioInicioSesion.invalid) {
      return null;
    }
    this.mostrarCarga().then(_ => {
      const usuario = new UsuarioSeguridad();
      usuario.nombreUsuario = this.f.nombreUsuario.value;
      usuario.password = this.f.password.value;
      this.seguridadService.getAuth(usuario).subscribe(response => {
        this.seguridadService.guardarToken(response.access_token);
        this.seguridadService.guardarDocumentoUsuario(this.f.nombreUsuario.value);
        this.menu.enable(true);
        this.navCtrl.navigateRoot('home');
        this.ocultarCarga();
      }, err => {
        if (err.status === 400) {
          this.mostrarToast('Número de identificación o contraseña incorrectos.');
          this.ocultarCarga();
        }
      });
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
      message: 'Iniciando sesión...'
    });
    return this.carga.present();
  }

  get f() { return this.formularioInicioSesion.controls; }

  redireccionRegistrarUsuario() {
    this.router.navigateByUrl('registro-usuario');
  }

  ocultarCarga() {
    this.carga.dismiss();
  }
}
