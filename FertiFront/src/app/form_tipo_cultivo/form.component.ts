import { Component } from '@angular/core';
import { TipoCultivoService } from '../servicios/tipo-cultivo.service';
import { TipoCultivo } from '../clases_dominio/tipo-cultivo';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent {

  formularioAgregarTipoCultivo: FormGroup;
  enviado = false;
  visible = false;


  constructor(private fb: FormBuilder, private tipoCultivoService: TipoCultivoService) { }

  private crearFormulario(): void {
    this.formularioAgregarTipoCultivo = this.fb.group({
      nombre: [null, [Validators.required]],
      variedad: [null, [Validators.required]],
      estado: [false, [Validators.required]],
    });
  }

  get f() { return this.formularioAgregarTipoCultivo.controls; }


  submit() {
    this.enviado = true;
    if (this.formularioAgregarTipoCultivo.invalid) {
      this.f.nombre.markAsDirty();
      this.f.nombre.updateValueAndValidity();
      this.f.variedad.markAsDirty();
      this.f.variedad.updateValueAndValidity();
      return null;
    }
    const tipoCultivo = new TipoCultivo();
    tipoCultivo.nombre = this.f.nombre.value;
    tipoCultivo.variedad = this.f.variedad.value;
    tipoCultivo.estado = this.f.estado.value;

    this.tipoCultivoService.updateOrCreate(tipoCultivo).subscribe(accion => {
      this.tipoCultivoService.cargarDatos();
      this.close();
    });
  }

  open(): void {
    this.crearFormulario();
    this.visible = true;
    this.enviado = false;
  }

  close(): void {
    this.formularioAgregarTipoCultivo.reset();
    this.visible = false;
  }




}
