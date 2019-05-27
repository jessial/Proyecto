import { SeguridadService } from './../../servicios/seguridad.service';
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

  constructor(private fb: FormBuilder, private router: Router,
    private menu: MenuController, private seguridadService: SeguridadService) {
    this.menu.enable(false);
  }

  ngOnInit() {
    this.formularioInicioSesion = this.fb.group({
      cedula: [null, [Validators.required]],
      password: [null, [Validators.required]]
    });
  }

  iniciarSesion() {
    this.enviado = true;
    if (this.f.invalid) {
      return null;
    }
    const usuario = new UsuarioSeguridad();
    usuario.cedula = this.f.cedula.value;
    usuario.password = this.f.password.value;
    this.seguridadService.getAuth(usuario);
  }

  get f() { return this.formularioInicioSesion.controls; }

  redireccionRegistrarUsuario() {
    this.router.navigateByUrl('registro-usuario');
  }

}
