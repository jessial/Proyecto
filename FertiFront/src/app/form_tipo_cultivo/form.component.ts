import { Component, OnInit, Input } from '@angular/core';
import { TipoCultivoService } from '../servicios/tipo-cultivo.service';

import {
  AbstractControl,
  FormBuilder,
  FormGroup,
  Validators
} from '@angular/forms';
import { TipoCultivo } from '../calses_dominio/tipo-cultivo';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  validateForm: FormGroup;

  @Input() tipoCultivo: TipoCultivo;

  submitForm(): void {
    for (const i in this.validateForm.controls) {
      this.validateForm.controls[ i ].markAsDirty();
      this.validateForm.controls[ i ].updateValueAndValidity();
    }
    this.ingresarDato();
  }

  constructor(private fb: FormBuilder, private tipoCultivoService: TipoCultivoService) {
  }

  ngOnInit(): void {
    this.tipoCultivo = new TipoCultivo();
    this.validateForm = this.fb.group({
      variedad: [ null, [ Validators.required ] ],
      nombre: [ null, [ Validators.required ] ]
    });
  }

  private ingresarDato(){
    this.tipoCultivoService.updateTiposCultivo(this.tipoCultivo);
  }

  editDate(event): void{
    console.log("event");
  }
}
