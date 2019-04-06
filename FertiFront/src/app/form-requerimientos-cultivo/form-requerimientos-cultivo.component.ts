import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { TipoCultivo } from '../clases_dominio/tipo-cultivo';
import { UnidadService } from '../servicios/unidad.service';
import { RequerimientoCultivoService } from '../servicios/requerimiento-cultivo.service';
import { TipoCultivoService } from '../servicios/tipo-cultivo.service';
import { Elemento } from '../clases_dominio/elemento';
import { ElementoService } from '../servicios/elemento.service';
import { Unidad } from '../clases_dominio/unidad';
import { RequerimientoCultivo } from '../clases_dominio/requerimiento-cultivo';

@Component({
  selector: 'app-form-requerimientos-cultivo',
  templateUrl: './form-requerimientos-cultivo.component.html',
  styleUrls: ['./form-requerimientos-cultivo.component.css']
})
export class FormRequerimientosCultivoComponent {

  formularioAgregarRequerimiento: FormGroup;
  public cultivos: TipoCultivo[];
  public elementos: Elemento[];
  public unidades: Unidad[];
  enviado = false;
  visible = false;
  constructor(private fb: FormBuilder, private servicioRequerimientos: RequerimientoCultivoService,
    private unidadServicio: UnidadService, private tipoCultivoServicio: TipoCultivoService, private elementoServicio: ElementoService) {
  }

  open() {
    this.crearFormulario();
    this.tipoCultivoServicio.getBackTiposCultivo().subscribe(result => {
      this.cultivos = result;
    });
    this.elementoServicio.getBackElementos().subscribe(result => {
      this.elementos = result;
    });
    this.unidadServicio.getBackUnidad().subscribe(result => {
      this.unidades = result;
    });
    this.visible = true;
    this.enviado = false;
  }

  private crearFormulario(): void {
    this.formularioAgregarRequerimiento = this.fb.group({
      tipoCultivo: [null, [Validators.required]],
      elemento: [null, [Validators.required]],
      unidad: [null, [Validators.required]],
      cantidad: [null, [Validators.required]],
      estado: [false, [Validators.required]]
    });
  }

  submit() {
    this.enviado = true;
    if (this.formularioAgregarRequerimiento.invalid) {
      return null;
    }
    const requerimiento = new RequerimientoCultivo();
    requerimiento.tipoCultivo = this.f.tipoCultivo.value;
    requerimiento.elemento = this.f.elemento.value;
    requerimiento.estado = this.f.estado.value;
    requerimiento.cantidad = this.f.cantidad.value;
    requerimiento.unidad = this.f.unidad.value;

    this.servicioRequerimientos.updateOrCreate(requerimiento).subscribe(accion => {
      this.servicioRequerimientos.cargarDatos();
      this.close();
    });
  }

  get f() { return this.formularioAgregarRequerimiento.controls; }

  close(): void {
    this.formularioAgregarRequerimiento.reset();
    this.visible = false;
  }

}
