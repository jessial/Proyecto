import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { TipoCultivo } from '../clases_dominio/tipo-cultivo';
import { TipoCultivoService } from '../servicios/tipo-cultivo.service';

@Component({
  selector: 'app-form-tipo-cultivo-edicion',
  templateUrl: './form-tipo-cultivo-edicion.component.html',
  styleUrls: ['./form-tipo-cultivo-edicion.component.css']
})
export class FormTipoCultivoEdicionComponent implements OnInit {

  formularioEditarTipoCultivo: FormGroup;
  private tipoCultivoSubject = new TipoCultivo();
  enviado = false;
  visible = false;


  constructor(private fb: FormBuilder, private tipoCultivoService: TipoCultivoService) { }

  ngOnInit() {
    this.crearFormulario();
  }
  private crearFormulario(): void {
    this.formularioEditarTipoCultivo = this.fb.group({
      nombre: [null, [Validators.required]],
      variedad: [null, [Validators.required]],
      estado: [false, [Validators.required]],
    });
  }

  get f() { return this.formularioEditarTipoCultivo.controls; }

  private cargarTipoCultivo() {
    this.tipoCultivoService.getCultivo().subscribe(result => {
      this.tipoCultivoSubject = result;
      this.f.nombre.setValue(result.nombre);
      this.f.variedad.setValue(result.variedad);
      this.f.estado.setValue(result.estado);
    });
  }

  submit() {
    this.enviado = true;
    if (this.formularioEditarTipoCultivo.invalid) {
      this.f.nombre.markAsDirty();
      this.f.nombre.updateValueAndValidity();
      this.f.variedad.markAsDirty();
      this.f.variedad.updateValueAndValidity();
      return null;
    }
    this.tipoCultivoSubject.nombre = this.f.nombre.value;
    this.tipoCultivoSubject.variedad = this.f.variedad.value;
    this.tipoCultivoSubject.estado = this.f.estado.value;

    this.tipoCultivoService.updateOrCreate(this.tipoCultivoSubject).subscribe(accion => {
      this.tipoCultivoService.cargarDatos();
      this.close();
    });
  }

  open(): void {
    this.crearFormulario();
    this.visible = true;
    this.enviado = false;
    this.cargarTipoCultivo();
  }

  close(): void {
    this.formularioEditarTipoCultivo.reset();
    this.visible = false;
  }




}
