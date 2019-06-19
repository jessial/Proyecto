import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, AbstractControl } from '@angular/forms';
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
      numeroIdentificacion: [null, [Validators.required, Validators.min(100), Validators.max(9999999999)]],
      nombre: [null, [Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
      apellido: [null, [Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
      correo: [null, [Validators.required, Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$')]],
      rol: [null, Validators.required],
      telefono: [null, [Validators.required, Validators.min(1), Validators.max(9999999999)]],
      password: [null, [Validators.required, Validators.minLength(5), Validators.maxLength(20)]],
      confirmacionPassword: [null, [Validators.required, Validators.minLength(5), Validators.maxLength(12)]]
    },
      {
        validator: this.passwordMatchValidator
      }
    );
  }

  registrarUsuario() {
    this.enviado = true;
    if (this.formularioRegistroUsuario.invalid) {
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

  private passwordMatchValidator(control: AbstractControl) {
    const password: string = control.get('password').value;
    const confirmPassword: string = control.get('confirmacionPassword').value;
    if (password !== confirmPassword) {
      control.get('confirmacionPassword').setErrors({ NoPassswordMatch: true });
    }
  }

}
