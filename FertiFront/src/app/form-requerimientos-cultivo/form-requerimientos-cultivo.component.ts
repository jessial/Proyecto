import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { RequerimientoCultivo } from '../calses_dominio/requerimiento-cultivo';

@Component({
  selector: 'app-form-requerimientos-cultivo',
  templateUrl: './form-requerimientos-cultivo.component.html',
  styleUrls: ['./form-requerimientos-cultivo.component.css']
})
export class FormRequerimientosCultivoComponent implements OnInit {
  validateForm: FormGroup;
  private requerimientoCultivo = new RequerimientoCultivo();

  submitForm(): void {
    for (const i in this.validateForm.controls) {
      this.validateForm.controls[i].markAsDirty();
      this.validateForm.controls[i].updateValueAndValidity();
    }
  }

  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    this.validateForm = this.fb.group({
      cultivo: [null, [Validators.required]],
      nitrogeno: [null, [Validators.required]],
      fosforo: [null, [Validators.required]],
      potasio: [null, [Validators.required]],
      magnesio: [null],
      calcio: [null],
      aluminio: [null],
      sodio: [null],
      azufre: [null],
      hierro: [null],
      boro: [null],
      cobre: [null],
      manganeso: [null],
      zinc: [null],
    });
  }

}
