import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Rol } from '../clases_dominio/rol';
import { RolService } from '../servicios/rol.service';

@Component({
  selector: 'app-form-rol-edicion',
  templateUrl: './form-rol-edicion.component.html',
  styleUrls: ['./form-rol-edicion.component.css']
})
export class FormRolEdicionComponent implements OnInit {

  formularioEditarRol: FormGroup;
  private rolSubject = new Rol();
  visible = false;
  enviado = true;

  constructor(private fb: FormBuilder, private servicioRol: RolService) {
  }

  ngOnInit() {
    this.crearFormulario();
  }

  private crearFormulario(): void {
    this.formularioEditarRol = this.fb.group({
      nombre: [null, [Validators.required]],
      estado: [false, [Validators.required]],
    });
  }

  get f() { return this.formularioEditarRol.controls; }

  private cargarRol() {
    this.servicioRol.getRol().subscribe(result => {
      this.rolSubject = result;
      this.f.nombre.setValue(result.nombre);
      this.f.estado.setValue(result.estado);
    });
  }

  submit() {
    this.enviado = true;
    if (this.formularioEditarRol.invalid) {
      this.f.nombre.markAsDirty();
      this.f.nombre.updateValueAndValidity();
      return null;
    }
    this.rolSubject.nombre = this.f.nombre.value;
    this.rolSubject.estado = this.f.estado.value;

    this.servicioRol.updateOrCreate(this.rolSubject).subscribe(accion => {
      this.servicioRol.cargarDatos();
      this.close();
    });
  }

  open(): void {
    this.crearFormulario();
    this.visible = true;
    this.enviado = false;
    this.cargarRol();
  }

  close(): void {
    this.formularioEditarRol.reset();
    this.visible = false;
  }
}





