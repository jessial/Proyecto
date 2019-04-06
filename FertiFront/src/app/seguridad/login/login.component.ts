import { Component, OnInit } from '@angular/core';
import { SeguridadService } from '../servicios/seguridad.service'
import {
  AbstractControl,
  FormBuilder,
  FormGroup,
  Validators
} from '@angular/forms';
import { Router } from '@angular/router';
import { from } from 'rxjs';
import { Usuario } from 'src/app/clases_dominio/usuario';
import { UsuarioSeguridad } from 'src/app/clases_dominio/usuarioSeguridad';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  validateForm: FormGroup;

  submitForm(): void {
    for (const i in this.validateForm.controls) {
      this.validateForm.controls[ i ].markAsDirty();
      this.validateForm.controls[ i ].updateValueAndValidity();
    }
    let usuario: UsuarioSeguridad = {
      cedula : this.validateForm.get('userName').value,
      password : this.validateForm.get('password').value
    }
    this.seguridadService.getAuth(usuario);
  }

  constructor(private fb: FormBuilder, private router: Router, private seguridadService : SeguridadService ) {
  }

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      userName: [ null, [ Validators.required ] ],
      password: [ null, [ Validators.required ] ],
      remember: [ false ]
    });
  }
}
