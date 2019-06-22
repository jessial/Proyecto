import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subscription } from 'rxjs';
import { Elemento } from '../clases_dominio/elemento';
import { Unidad } from '../clases_dominio/unidad';
import { ElementoService } from '../servicios/elemento.service';
import { TipoFuenteService } from '../servicios/tipo-fuente.service';
import { TipoFuente } from './../clases_dominio/tipo-fuente';

@Component({
  selector: 'app-form-tipo-fuente-edicion',
  templateUrl: './form-tipo-fuente-edicion.component.html',
  styleUrls: ['./form-tipo-fuente-edicion.component.css']
})
export class FormTipoFuenteEdicionComponent implements OnInit {

  formularioEditarTipoFuente: FormGroup;
  private tipoFuenteSubject = new TipoFuente();
  subscription: Subscription;
  public elementos: Elemento[];
  visible = false;
  enviado = false;

  unidad: Unidad =
    {
      codigoUnidad: 3,
      nombreUnidad: 'kg/ha'
    };
  constructor(private fb: FormBuilder,
    private servicioTipoFuente: TipoFuenteService, private elementoServicio: ElementoService) {
  }

  ngOnInit() {
    this.formularioEditarTipoFuente = this.fb.group({
      nombre: [null, [Validators.required]],
      aporte: [null, [Validators.required]],
      elemento: [null, [Validators.required]],
      estado: [false, [Validators.required]],
    });
    this.elementoServicio.getBackElementos().subscribe(result => {
      this.elementos = result;
    });
  }

  private cargarTipoFuente() {
    this.servicioTipoFuente.getTipoFuente()
      .subscribe(result => {
        this.tipoFuenteSubject = result;
        this.f.nombre.setValue(result.nombre);
        this.f.aporte.setValue(result.aporte);
        this.f.estado.setValue(result.estado);
        this.f.elemento.setValue(result.elemento.codigoElemento);
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
    this.tipoFuenteSubject.unidad = this.unidad;
    this.tipoFuenteSubject.estado = this.f.estado.value;
    this.tipoFuenteSubject.elemento = this.elementos.find(elemento => elemento.codigoElemento === this.f.elemento.value);
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
