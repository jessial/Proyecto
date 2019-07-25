import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Unidad } from '../clases_dominio/unidad';
import { RequerimientoCultivoService } from '../servicios/requerimiento-cultivo.service';
import { TipoCultivoService } from '../servicios/tipo-cultivo.service';
import { Elemento } from './../clases_dominio/elemento';
import { RequerimientoCultivo } from './../clases_dominio/requerimiento-cultivo';
import { TipoCultivo } from './../clases_dominio/tipo-cultivo';
import { ElementoService } from './../servicios/elemento.service';
import { UtilidadService } from '../servicios/utilidad.service';

@Component({
  selector: 'app-form-requerimientos-cultivo-edicion',
  templateUrl: './form-requerimientos-cultivo-edicion.component.html',
  styleUrls: ['./form-requerimientos-cultivo-edicion.component.css']
})
export class FormRequerimientosCultivoEdicionComponent implements OnInit {

  formularioAgregarRequerimiento: FormGroup;
  private requerimientoSubject = new RequerimientoCultivo();
  public cultivos: TipoCultivo[];
  public elementos: Elemento[];
  public unidades: Unidad[];
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

  ngOnInit() {
    this.formularioAgregarRequerimiento = this.fb.group({
      tipoCultivo: [null, [Validators.required]],
      elemento: [null, [Validators.required]],
      cantidad: [null, [Validators.required]],
      estado: [false, [Validators.required]]
    });
    this.tipoCultivoServicio.getBackTiposCultivo().subscribe(result => {
      this.cultivos = result;
    });
    this.elementoServicio.getBackElementos().subscribe(result => {
      this.elementos = result;
    });
  }

  open() {
    this.visible = true;
    this.enviado = false;
    this.cargarRequerimiento();
  }

  private cargarRequerimiento(): void {
    this.servicioRequerimientos.getRequerimiento()
      .subscribe(result => {
        this.requerimientoSubject = result;
        this.f.tipoCultivo.setValue(result.tipoCultivo.codigoTipoCultivo);
        this.f.elemento.setValue(result.elemento.codigoElemento);
        this.f.cantidad.setValue(result.cantidad);
        this.f.estado.setValue(result.estado);
      }
      );
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
          .filter(r => r.tipoCultivo.codigoTipoCultivo === this.f.tipoCultivo.value)
          .filter(r => r.elemento.codigoElemento === this.f.elemento.value)
          .filter(r => r.codigoRequerimiento !== this.requerimientoSubject.codigoRequerimiento).length;
        if (numero > 0) {
          this.utilidad.mensajeErrorEliminar(`No es posible agregar el requerimiento, ya que para el tipo de cultivo existe el elemento.`);
          return null;
        }
        this.requerimientoSubject.tipoCultivo = this.cultivos.find(cultivo => cultivo.codigoTipoCultivo === this.f.tipoCultivo.value);
        this.requerimientoSubject.elemento = this.elementos.find(elemento => elemento.codigoElemento === this.f.elemento.value);
        this.requerimientoSubject.estado = this.f.estado.value;
        this.requerimientoSubject.cantidad = this.f.cantidad.value;
        this.requerimientoSubject.unidad = this.unidad;

        this.servicioRequerimientos.updateOrCreate(this.requerimientoSubject).subscribe(accion => {
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
