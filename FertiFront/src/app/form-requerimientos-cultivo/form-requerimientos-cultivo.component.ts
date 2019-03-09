import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { RequerimientoCultivo } from '../clases_dominio/requerimiento-cultivo';
import { TipoCultivo } from '../clases_dominio/tipo-cultivo';
import { Subscription } from 'rxjs';
import { LocalService } from '../servicios/local.service';
import { UnidadService } from '../servicios/unidad.service';
import { RequerimientoCultivoService } from '../servicios/requerimiento-cultivo.service';
import { TipoCultivoService } from '../servicios/tipo-cultivo.service';
import { Elemento } from '../clases_dominio/elemento';
import { ElementoService } from '../servicios/elemento.service';
import { Unidad } from '../clases_dominio/unidad';

@Component({
  selector: 'app-form-requerimientos-cultivo',
  templateUrl: './form-requerimientos-cultivo.component.html',
  styleUrls: ['./form-requerimientos-cultivo.component.css']
})
export class FormRequerimientosCultivoComponent implements OnInit, OnDestroy {
  validateForm: FormGroup;
  private requerimientoCultivo = new RequerimientoCultivo();
  private cultivos: TipoCultivo[];
  private elementos: Elemento[];
  private unidades: Unidad[];

  subscription: Subscription;

  submitForm(): void {
    for (const i in this.validateForm.controls) {
      this.validateForm.controls[i].markAsDirty();
      this.validateForm.controls[i].updateValueAndValidity();
    }
  }

  constructor(private fb: FormBuilder,
    private servicioLocal: LocalService, private servicioRequerimientos: RequerimientoCultivoService,
    private unidadServicio: UnidadService, private tipoCultivoServicio: TipoCultivoService, private elementoServicio: ElementoService) {
    this.subscription = this.servicioLocal.obtenerAccion().subscribe(accion => {
      this.servicioRequerimientos.updateOrCreate(this.requerimientoCultivo).subscribe(accion => {
        this.servicioRequerimientos.cargarDatos();
      });
    });
  }
  ngOnInit() {
    this.cargarRequerimiento();
    this.validateForm = this.fb.group({
      cultivo: [null, [Validators.required]],
      elemento: [null, [Validators.required]],
      unidad: [null, [Validators.required]],
      cantidad: [null, [Validators.required]],
      estado: [null, [Validators.required]]
    });
    this.tipoCultivoServicio.getBackTiposCultivo().subscribe(result => {
      this.cultivos = result;
    });
    this.elementoServicio.getBackElementos().subscribe(result => {
      this.elementos = result;
    });
    this.unidadServicio.getBackUnidad().subscribe(result => {
      this.unidades = result;
    });
  }


  private cargarRequerimiento() {
    this.servicioRequerimientos.getRequerimiento().subscribe(result => {
      this.requerimientoCultivo = result;
    });
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

}
