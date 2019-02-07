import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '../../../node_modules/@angular/forms';
import { TipoFuente } from '../calses_dominio/tipo-fuente';
import { Subscription } from '../../../node_modules/rxjs';
import { LocalService } from '../servicios/local.service';
import { TipoFuenteService } from '../servicios/tipo-fuente.service';
import { jsonpCallbackContext } from '../../../node_modules/@angular/common/http/src/module';

@Component({
  selector: 'app-form-tipo-fuente',
  templateUrl: './form-tipo-fuente.component.html',
  styleUrls: ['./form-tipo-fuente.component.css']
})
export class FormTipoFuenteComponent implements OnInit, OnDestroy {

  validateForm: FormGroup;
  private tipoFuente = new TipoFuente();
  subscription: Subscription;

  submitForm(): void {
    for (const i in this.validateForm.controls) {
      this.validateForm.controls[i].markAsDirty();
      this.validateForm.controls[i].updateValueAndValidity();
    }
  }

  constructor(private fb: FormBuilder,
    private servicioLocal: LocalService, private servicioTipoFuente: TipoFuenteService) {
    this.subscription = this.servicioLocal.obtenerAccion().subscribe(accion => {
      this.servicioTipoFuente.updateOrCreate(this.tipoFuente).subscribe(accion => {
        this.servicioTipoFuente.cargarDatos();
      });
    });
  }

  ngOnInit() {
    this.cargarTipoFuente();
    this.validateForm = this.fb.group({
      nombre: [null, [Validators.required]],
      aporte: [null, [Validators.required]],
      unidad: [null, [Validators.required]]
    });
  }

  private cargarTipoFuente() {
    this.servicioTipoFuente.getTipoFuente()
      .subscribe(result => {
        this.tipoFuente = result;
      }
      );
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }
}

