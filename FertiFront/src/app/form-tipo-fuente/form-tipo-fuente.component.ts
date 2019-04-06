import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '../../../node_modules/@angular/forms';
import { TipoFuente } from '../clases_dominio/tipo-fuente';
import { TipoFuenteService } from '../servicios/tipo-fuente.service';
import { UnidadService } from '../servicios/unidad.service';
import { Unidad } from '../clases_dominio/unidad';

@Component({
  selector: 'app-form-tipo-fuente',
  templateUrl: './form-tipo-fuente.component.html',
  styleUrls: ['./form-tipo-fuente.component.css']
})
export class FormTipoFuenteComponent {

  formularioAgregarTipoFuente: FormGroup;
  public unidades: Unidad[];
  enviado = false;
  visible = false;

  constructor(private fb: FormBuilder, private servicioTipoFuente: TipoFuenteService,
    private unidadServicio: UnidadService) {
  }

  private crearFormulario(): void {
    this.formularioAgregarTipoFuente = this.fb.group({
      nombre: [null, [Validators.required]],
      aporte: [null, [Validators.required]],
      unidad: [null, [Validators.required]],
      estado: [false, [Validators.required]],
    });
  }

  submit() {
    this.enviado = true;
    if (this.formularioAgregarTipoFuente.invalid) {
      return null;
    }
    const tipoFuente = new TipoFuente();
    tipoFuente.nombre = this.f.nombre.value;
    tipoFuente.aporte = this.f.aporte.value;
    tipoFuente.unidad = this.f.unidad.value;
    tipoFuente.estado = this.f.estado.value;

    this.servicioTipoFuente.updateOrCreate(tipoFuente).subscribe(accion => {
      this.servicioTipoFuente.cargarDatos();
      this.close();
    });
  }

  get f() { return this.formularioAgregarTipoFuente.controls; }

  open(): void {
    this.crearFormulario();
    this.unidadServicio.getBackUnidad().subscribe(result => {
      this.unidades = result;
    });
    this.visible = true;
    this.enviado = false;
  }

  close(): void {
    this.formularioAgregarTipoFuente.reset();
    this.visible = false;
  }
}

