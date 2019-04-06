import { TipoFuente } from './../clases_dominio/tipo-fuente';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { UnidadService } from '../servicios/unidad.service';
import { TipoFuenteService } from '../servicios/tipo-fuente.service';
import { Subscription } from 'rxjs';
import { Unidad } from '../clases_dominio/unidad';

@Component({
  selector: 'app-form-tipo-fuente-edicion',
  templateUrl: './form-tipo-fuente-edicion.component.html',
  styleUrls: ['./form-tipo-fuente-edicion.component.css']
})
export class FormTipoFuenteEdicionComponent implements OnInit {

  formularioEditarTipoFuente: FormGroup;
  private tipoFuenteSubject = new TipoFuente();
  subscription: Subscription;
  public unidades: Unidad[];
  visible = false;
  enviado = false;

  constructor(private fb: FormBuilder,
    private servicioTipoFuente: TipoFuenteService,
    private unidadServicio: UnidadService) {
  }

  ngOnInit() {
    this.formularioEditarTipoFuente = this.fb.group({
      nombre: [null, [Validators.required]],
      aporte: [null, [Validators.required]],
      unidad: [null, [Validators.required]],
      estado: [false, [Validators.required]],
    });
    this.unidadServicio.getBackUnidad().subscribe(result => {
      this.unidades = result;
    });
  }

  private cargarTipoFuente() {
    this.servicioTipoFuente.getTipoFuente()
      .subscribe(result => {
        this.tipoFuenteSubject = result;
        this.f.nombre.setValue(result.nombre);
        this.f.aporte.setValue(result.aporte);
        this.f.unidad.setValue(result.unidad.codigoUnidad);
        this.f.estado.setValue(result.estado);
      }
      );
  }

  submit() {
    this.enviado = true;
    if (this.formularioEditarTipoFuente.invalid) {
      return null;
    }
    this.tipoFuenteSubject.nombre = this.f.nombre.value;
    this.tipoFuenteSubject.aporte = this.f.aporte.value;
    this.tipoFuenteSubject.unidad = this.unidades.find(unidad => unidad.codigoUnidad === this.f.unidad.value);
    this.tipoFuenteSubject.estado = this.f.estado.value;

    this.servicioTipoFuente.updateOrCreate(this.tipoFuenteSubject).subscribe(accion => {
      this.servicioTipoFuente.cargarDatos();
      this.close();
    });
  }

  get f() { return this.formularioEditarTipoFuente.controls; }

  open(): void {
    this.visible = true;
    this.enviado = false;
    this.cargarTipoFuente();
  }

  close(): void {
    this.formularioEditarTipoFuente.reset();
    this.visible = false;
  }
}
