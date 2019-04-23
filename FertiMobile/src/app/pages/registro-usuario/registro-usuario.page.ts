import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastController } from '@ionic/angular';
import { UsuarioSeguridad } from 'src/app/dominio/usuario-seguridad';

@Component({
  selector: 'app-registro-usuario',
  templateUrl: './registro-usuario.page.html',
  styleUrls: ['./registro-usuario.page.scss'],
})
export class RegistroUsuarioPage implements OnInit {

  enviado = false;
  formularioRegistroUsuario: FormGroup;

  constructor(private fb: FormBuilder, private router: Router) { }

  ngOnInit() {
    this.formularioRegistroUsuario = this.fb.group({
      nombreUsuario: [null, [Validators.required]],
      password: [null, [Validators.required]]
    });
  }

  registrarUsuario() {
    this.enviado = true;
    if (this.f.invalid) {
      return null;
    }
    const usuario = new UsuarioSeguridad();
    usuario.nombreUsuario = this.f.nombreUsuario.value;
    usuario.password = this.f.password.value;
    // TODO: Consumir servicio incio de sesión...
    console.log(usuario);
  }

  get f() { return this.formularioRegistroUsuario.controls; }

  redireccionRegistrarUsuario() {
    this.router.navigateByUrl('registro-usuario');
  }
}
