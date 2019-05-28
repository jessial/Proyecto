import { Component, OnInit } from '@angular/core';
import { SeguridadService } from '../servicios/seguridad.service'
import {
  AbstractControl,
  FormBuilder,
  FormGroup,
  Validators
} from '@angular/forms';
import { Router } from '@angular/router';
import { UsuarioSeguridad } from 'src/app/clases_dominio/usuarioSeguridad';
import { UtilidadService } from '../../servicios/utilidad.service'

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
      nombreUsuario : this.validateForm.get('userName').value,
      password : this.validateForm.get('password').value
    }
    this.seguridadService.getAuth(usuario).subscribe(response =>{
      if(response.rol[0].authority != "ROLE_ADMIN"){
        this.utilidad.mensajeAlerta('Error', 'El usuario no tiene los permisos para Ingresar');
        this.seguridadService.logout();
      }
      else{
        this.seguridadService.guardarToken(response.access_token);
        this.router.navigate(['/lista_parcelas']);
        this.utilidad.mensajeExito('Éxito', 'Bienvenido');
      }
    }, err => {
      if(err.status == 400){
        this.utilidad.mensajeAlerta('Error', 'Usuario o clave incorrecta');
      }
    });
  }

  constructor(private fb: FormBuilder, private router: Router, private seguridadService : SeguridadService, private utilidad: UtilidadService ) {
  }

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      userName: [ null, [ Validators.required ] ],
      password: [ null, [ Validators.required ] ],
      remember: [ false ]
    });
  }
}
