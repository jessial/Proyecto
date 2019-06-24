import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '../../../node_modules/@angular/forms';
import { Elemento } from '../clases_dominio/elemento';
import { TipoFuente } from '../clases_dominio/tipo-fuente';
import { Unidad } from '../clases_dominio/unidad';
import { ElementoService } from '../servicios/elemento.service';
import { TipoFuenteService } from '../servicios/tipo-fuente.service';

@Component({
  selector: 'app-form-tipo-fuente',
  templateUrl: './form-tipo-fuente.component.html',
  styleUrls: ['./form-tipo-fuente.component.css']
})
export class FormTipoFuenteComponent {

  formularioAgregarTipoFuente: FormGroup;
  public elementos: Elemento[];
  enviado = false;
  visible = false;

  unidad: Unidad =
    {
      codigoUnidad: 3,
      nombreUnidad: 'kg/ha'
    };

  constructor(private fb: FormBuilder, private servicioTipoFuente: TipoFuenteService,
    private elementoServicio: ElementoService) {
  }

  private crearFormulario(): void {
    this.formularioAgregarTipoFuente = this.fb.group({
      nombre: [null, [Validators.required]],
      elemento: [null, [Validators.required]],
      aporte: [null, [Validators.required]],
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
    tipoFuente.unidad = this.unidad;
    tipoFuente.estado = this.f.estado.value;
    tipoFuente.elemento = this.f.elemento.value;
    this.servicioTipoFuente.updateOrCreate(tipoFuente).subscribe(accion => {
      this.servicioTipoFuente.cargarDatos();
      this.close();
    });
  }

  get f() { return this.formularioAgregarTipoFuente.controls; }

  open(): void {
    this.crearFormulario();
    this.elementoServicio.getBackElementos().subscribe(result => {
      this.elementos = result;
    });
    this.visible = true;
    this.enviado = false;
  }

  close(): void {
    this.formularioAgregarTipoFuente.reset();
    this.visible = false;
  }



}

