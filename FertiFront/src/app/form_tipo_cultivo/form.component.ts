import { Component, OnInit, Input } from '@angular/core';
import { TipoCultivoService } from '../servicios/tipo-cultivo.service';
import { TipoCultivo } from '../calses_dominio/tipo-cultivo';

import {
  AbstractControl,
  FormBuilder,
  FormGroup,
  Validators
} from '@angular/forms';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  validateForm: FormGroup;
  public tipoCultivo = new TipoCultivo();

  submitForm(): void {
    for (const i in this.validateForm.controls) {
      this.validateForm.controls[ i ].markAsDirty();
      this.validateForm.controls[ i ].updateValueAndValidity();
    }
    console.log(this.tipoCultivo);
  }

  constructor(private fb: FormBuilder, private tipoCultivoService: TipoCultivoService) {
  }

  ngOnInit(): void {
    this.cargarTipoCultivo();
    this.validateForm = this.fb.group({
      variedad: [ null, [ Validators.required ] ],
      nombre: [ null, [ Validators.required ] ]
    });
  }

  private cargarTipoCultivo(){
    this.tipoCultivoService.getCultivo()
    .subscribe(result => {
      this.tipoCultivo = result;
    }
    );
  }

  lllllll(){
    console.log("fdhgdhfghdg");
  }
}
