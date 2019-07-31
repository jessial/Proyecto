import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Elemento } from '../clases_dominio/elemento';
import { RequerimientoCultivo } from '../clases_dominio/requerimiento-cultivo';
import { TipoCultivo } from '../clases_dominio/tipo-cultivo';
import { Unidad } from '../clases_dominio/unidad';
import { ElementoService } from '../servicios/elemento.service';
import { RequerimientoCultivoService } from '../servicios/requerimiento-cultivo.service';
import { TipoCultivoService } from '../servicios/tipo-cultivo.service';
import { UtilidadService } from '../servicios/utilidad.service';

@Component({
  selector: 'app-form-requerimientos-cultivo',
  templateUrl: './form-requerimientos-cultivo.component.html',
  styleUrls: ['./form-requerimientos-cultivo.component.css']
})
export class FormRequerimientosCultivoComponent {

  formularioAgregarRequerimiento: FormGroup;
  public cultivos: TipoCultivo[];
  public elementos: Elemento[];
  enviado = false;
  visible = false;
  unidad: Unidad =
    {
      codigoUnidad: 3,
      nombreUnidad: 'kg/ha'
    };

  constructor(private fb: FormBuilder, private servicioRequerimientos: RequerimientoCultivoService,
    private tipoCultivoServicio: TipoCultivoService, private elementoServicio: ElementoService,
    private utilidad: UtilidadService) {
  }

  open() {
    this.crearFormulario();
    this.tipoCultivoServicio.getBackTiposCultivo().subscribe(result => {
      this.cultivos = result;
    });
    this.elementoServicio.getBackElementos().subscribe(result => {
      this.elementos = result;
    });
    this.visible = true;
    this.enviado = false;
  }

  private crearFormulario(): void {
    this.formularioAgregarRequerimiento = this.fb.group({
      tipoCultivo: [null, [Validators.required]],
      elemento: [null, [Validators.required]],
      cantidad: [null, [Validators.required]],
      estado: [false, [Validators.required]]
    });
  }

  submit() {
    this.enviado = true;
    this.servicioRequerimientos.getRequerimientosPorCultivo()
      .subscribe(resultado => {
        if (this.formularioAgregarRequerimiento.invalid) {
          this.f.tipoCultivo.markAsDirty();
          this.f.tipoCultivo.updateValueAndValidity();
          this.f.elemento.markAsDirty();
          this.f.elemento.updateValueAndValidity();
          this.f.cantidad.markAsDirty();
          this.f.cantidad.updateValueAndValidity();
          return null;
        }
        const numero = resultado
          .filter(r => r.tipoCultivo.codigoTipoCultivo === this.f.tipoCultivo.value.codigoTipoCultivo)
          .filter(r => r.elemento.codigoElemento === this.f.elemento.value.codigoElemento).length;
        if (numero > 0) {
          this.utilidad.mensajeErrorEliminar(`No es posible agregar el requerimiento, ya que para el tipo de cultivo existe el elemento.`);
          return null;
        }
        const requerimiento = new RequerimientoCultivo();
        requerimiento.tipoCultivo = this.f.tipoCultivo.value;
        requerimiento.elemento = this.f.elemento.value;
        requerimiento.estado = this.f.estado.value;
        requerimiento.cantidad = this.f.cantidad.value;
        requerimiento.unidad = this.unidad;

        this.servicioRequerimientos.updateOrCreate(requerimiento).subscribe(accion => {
          this.servicioRequerimientos.cargarDatos();
          this.close();
        });
      });
  }

  get f() { return this.formularioAgregarRequerimiento.controls; }

  close(): void {
    this.formularioAgregarRequerimiento.reset();
    this.visible = false;
  }

}
