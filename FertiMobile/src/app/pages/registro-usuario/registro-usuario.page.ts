import { Rol } from './../../dominio/rol';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UsuarioSeguridad } from 'src/app/dominio/usuario-seguridad';
import { RolService } from 'src/app/servicios/rol.service';

@Component({
  selector: 'app-registro-usuario',
  templateUrl: './registro-usuario.page.html',
  styleUrls: ['./registro-usuario.page.scss'],
})
export class RegistroUsuarioPage implements OnInit {

  enviado = false;
  formularioRegistroUsuario: FormGroup;
  roles: Rol[] = [];

  constructor(private fb: FormBuilder, private rolServicio: RolService) { }

  ngOnInit() {
    this.rolServicio.cargarDatos();
    this.rolServicio.getRoles().subscribe(roles => {
      this.roles = roles;
    });
    this.formularioRegistroUsuario = this.fb.group({
      numeroIdentificacion: [null, Validators.required],
      nombre: [null, Validators.required],
      apellido: [null, Validators.required],
      correo: [null, Validators.required],
      rol: [null, Validators.required],
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

}
