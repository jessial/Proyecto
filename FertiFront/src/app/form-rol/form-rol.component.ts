import { Component, OnInit } from '@angular/core';
import { Rol } from '../calses_dominio/rol';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-form-rol',
  templateUrl: './form-rol.component.html',
  styleUrls: ['./form-rol.component.css']
})
export class FormRolComponent implements OnInit {
  validateForm: FormGroup;
  private rol = new Rol();

  submitForm(): void {
    for (const i in this.validateForm.controls) {
      this.validateForm.controls[i].markAsDirty();
      this.validateForm.controls[i].updateValueAndValidity();
    }
  }

  constructor(private fb: FormBuilder) {
  }

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      nombre: [null, [Validators.required]]
    });
  }
}
