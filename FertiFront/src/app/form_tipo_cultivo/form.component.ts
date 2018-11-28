import { Component, OnInit, Input, OnDestroy } from '@angular/core';
import { TipoCultivoService } from '../servicios/tipo-cultivo.service';
import { TipoCultivo } from '../calses_dominio/tipo-cultivo';

import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subscription } from 'rxjs';
import { LocalService } from '../servicios/local.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit, OnDestroy {

  validateForm: FormGroup;
  public tipoCultivo = new TipoCultivo();
  subscription: Subscription;

  submitForm(): void {
    for (const i in this.validateForm.controls) {
      this.validateForm.controls[i].markAsDirty();
      this.validateForm.controls[i].updateValueAndValidity();
    }
  }

  constructor(private fb: FormBuilder,
    private servicioLocal: LocalService, private tipoCultivoService: TipoCultivoService) {
    this.subscription = this.servicioLocal.obtenerAccion().subscribe(accion => {
      this.tipoCultivoService.updateOrCreate(this.tipoCultivo).subscribe(accion => {
        this.tipoCultivoService.cargarDatos();
      });
    });
  }

  ngOnInit(): void {
    this.cargarTipoCultivo();
    this.validateForm = this.fb.group({
      variedad: [null, [Validators.required]],
      nombre: [null, [Validators.required]]
    });
  }

  private cargarTipoCultivo() {
    this.tipoCultivoService.getCultivo()
      .subscribe(result => {
        this.tipoCultivo = result;
      }
      );
  }
  ngOnDestroy() {
    this.subscription.unsubscribe();
  }
}
