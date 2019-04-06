import { Fuente } from './../clases_dominio/fuente';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { TipoFuente } from '../clases_dominio/tipo-fuente';
import { FuenteService } from '../servicios/fuente.service';
import { TipoFuenteService } from '../servicios/tipo-fuente.service';

@Component({
  selector: 'app-form-fuente',
  templateUrl: './form-fuente.component.html',
  styleUrls: ['./form-fuente.component.css']
})
export class FormFuenteComponent {

  formularioAgregarFuente: FormGroup;
  public tipoFuentes: TipoFuente[];
  enviado = false;
  visible = false;

  constructor(private fb: FormBuilder, private servicioFuente: FuenteService,
    private tipoFuenteServicio: TipoFuenteService) {
  }

  private crearFormulario(): void {
    this.formularioAgregarFuente = this.fb.group({
      tipoFuente: [null, [Validators.required]],
      producto: [null, [Validators.required]],
      estado: [false, [Validators.required]],
    });
  }

  submit() {
    this.enviado = true;
    if (this.formularioAgregarFuente.invalid) {
      return null;
    }
    const fuente = new Fuente();
    fuente.tipoFuente = this.f.tipoFuente.value;
    fuente.producto = this.f.producto.value;
    fuente.estado = this.f.estado.value;

    this.servicioFuente.updateOrCreate(fuente).subscribe(accion => {
      this.servicioFuente.cargarDatos();
      this.close();
    });
  }

  get f() { return this.formularioAgregarFuente.controls; }

  open(): void {
    this.crearFormulario();
    this.tipoFuenteServicio.getBackTipoFuente().subscribe(result => {
      this.tipoFuentes = result;
    });
    this.visible = true;
    this.enviado = false;
  }

  close(): void {
    this.formularioAgregarFuente.reset();
    this.visible = false;
  }

}
