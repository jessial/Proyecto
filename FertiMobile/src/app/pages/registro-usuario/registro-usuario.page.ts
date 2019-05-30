import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoadingController, ToastController } from '@ionic/angular';
import { Usuario } from 'src/app/dominio/usuario';
import { RegistroUsuarioService } from 'src/app/servicios/registro-usuario.service';
import { RolService } from 'src/app/servicios/rol.service';
import { Rol } from './../../dominio/rol';
import { Location } from '@angular/common';

@Component({
  selector: 'app-registro-usuario',
  templateUrl: './registro-usuario.page.html',
  styleUrls: ['./registro-usuario.page.scss'],
})
export class RegistroUsuarioPage implements OnInit {

  enviado = false;
  formularioRegistroUsuario: FormGroup;
  roles: Rol[] = [];
  carga: any;

  constructor(private fb: FormBuilder, private rolServicio: RolService,
    private loadingController: LoadingController, private toastController: ToastController,
    private registroUsuarioServicio: RegistroUsuarioService, private location: Location) { }

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
      telefono: [null, [Validators.required]],
      password: [null, [Validators.required]]
    });
  }

  registrarUsuario() {
    this.enviado = true;
    if (this.f.invalid) {
      return null;
    }
    this.mostrarCarga().then(_ => {
      const usuario = new Usuario();
      usuario.cedula = this.f.numeroIdentificacion.value;
      usuario.codigoRol = this.f.rol.value;
      usuario.nombre = this.f.nombre.value;
      usuario.apellido = this.f.apellido.value;
      usuario.telefono = this.f.telefono.value;
      usuario.email = this.f.correo.value;
      usuario.password = this.f.password.value;
      this.registroUsuarioServicio.updateOrCreate(usuario).subscribe(
        resp => {
          this.mostrarToast('Éxito registrando usuario');
          this.location.back();
          this.ocultarCarga();
        },
        error => {
          this.mostrarToast('Error registrando usuario');
          this.ocultarCarga();
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
      message: 'Registrando usuario...'
    });
    return this.carga.present();
  }

  ocultarCarga() {
    this.carga.dismiss();
  }

  get f() { return this.formularioRegistroUsuario.controls; }

}
