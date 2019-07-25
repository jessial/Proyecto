import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RolService } from '../servicios/rol.service';
import { Rol } from '../clases_dominio/rol';

@Component({
  selector: 'app-form-rol',
  templateUrl: './form-rol.component.html',
  styleUrls: ['./form-rol.component.css']
})
export class FormRolComponent {
  formularioAgregarRol: FormGroup;
  enviado = false;
  visible = false;


  constructor(private fb: FormBuilder, private servicioRol: RolService) { }


  private crearFormulario(): void {
    this.formularioAgregarRol = this.fb.group({
      nombre: [null, [Validators.required]],
      estado: [false, [Validators.required]],
    });
  }

  get f() { return this.formularioAgregarRol.controls; }

  submit() {
    this.enviado = true;
    if (this.formularioAgregarRol.invalid) {
      this.f.nombre.markAsDirty();
      this.f.nombre.updateValueAndValidity();
      return null;
    }
    const rol = new Rol();
    rol.nombre = this.f.nombre.value;
    rol.estado = this.f.estado.value;

    this.servicioRol.updateOrCreate(rol).subscribe(accion => {
      this.servicioRol.cargarDatos();
      this.close();
    });

  }

  open(): void {
    this.crearFormulario();
    this.visible = true;
    this.enviado = false;
  }

  close(): void {
    this.formularioAgregarRol.reset();
    this.visible = false;
  }
}
