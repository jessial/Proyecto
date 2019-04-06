import { FuenteService } from './../servicios/fuente.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Fuente } from '../clases_dominio/fuente';
import { TipoFuente } from '../clases_dominio/tipo-fuente';
import { TipoFuenteService } from '../servicios/tipo-fuente.service';

@Component({
  selector: 'app-form-fuente-edicion',
  templateUrl: './form-fuente-edicion.component.html',
  styleUrls: ['./form-fuente-edicion.component.css']
})
export class FormFuenteEdicionComponent implements OnInit {

  formularioEditarFuente: FormGroup;
  private fuenteSubject = new Fuente();
  public tipoFuentes: TipoFuente[];
  visible = false;
  enviado = false;

  constructor(private fb: FormBuilder,
    private servicioTipoFuente: TipoFuenteService,
    private fuenteServicio: FuenteService) {
  }

  ngOnInit() {
    this.formularioEditarFuente = this.fb.group({
      tipoFuente: [null, [Validators.required]],
      producto: [null, [Validators.required]],
      estado: [false, [Validators.required]],
    });
    this.servicioTipoFuente.getBackTipoFuente().subscribe(result => {
      this.tipoFuentes = result;
    });
  }

  private cargarTipoFuente() {
    this.fuenteServicio.getFuente()
      .subscribe(result => {
        this.fuenteSubject = result;
        this.f.producto.setValue(result.producto);
        this.f.tipoFuente.setValue(result.tipoFuente.codigo);
        this.f.estado.setValue(result.estado);
      }
      );
  }

  submit() {
    this.enviado = true;
    if (this.formularioEditarFuente.invalid) {
      return null;
    }
    this.fuenteSubject.producto = this.f.producto.value;
    this.fuenteSubject.tipoFuente = this.tipoFuentes.find(tipoFuente => tipoFuente.codigo === this.f.tipoFuente.value);
    this.fuenteSubject.estado = this.f.estado.value;

    this.fuenteServicio.updateOrCreate(this.fuenteSubject).subscribe(accion => {
      this.fuenteServicio.cargarDatos();
      this.close();
    });
  }

  get f() { return this.formularioEditarFuente.controls; }

  open(): void {
    this.visible = true;
    this.enviado = false;
    this.cargarTipoFuente();
  }

  close(): void {
    this.formularioEditarFuente.reset();
    this.visible = false;
  }

}
