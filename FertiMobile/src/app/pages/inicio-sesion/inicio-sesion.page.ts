import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MenuController, NavController } from '@ionic/angular';
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

  constructor(private fb: FormBuilder, private router: Router, private navCtrl: NavController,
    private menu: MenuController, private seguridadService: SeguridadService) {
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
    this.seguridadService.getAuth(usuario).subscribe(response => {
      this.seguridadService.guardarToken(response.access_token);
      this.seguridadService.guardarDocumentoUsuario(this.f.nombreUsuario.value);
      this.menu.enable(true);
      this.navCtrl.navigateRoot('home');
      // this.utilidad.mensajeExito('Éxito', 'Bienvenido');
    }, err => {
      if (err.status === 400) {
        // this.utilidad.mensajeAlerta('Error', 'Usuario o clave incorrecta');
      }
    });
  }

  get f() { return this.formularioInicioSesion.controls; }

  redireccionRegistrarUsuario() {
    this.router.navigateByUrl('registro-usuario');
  }

}
