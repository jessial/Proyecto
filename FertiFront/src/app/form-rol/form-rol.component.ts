import { Component, OnInit, OnDestroy } from '@angular/core';
import { Rol } from '../calses_dominio/rol';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subscription } from 'rxjs';
import { LocalService } from '../servicios/local.service';
import { RolService } from '../servicios/rol.service';

@Component({
  selector: 'app-form-rol',
  templateUrl: './form-rol.component.html',
  styleUrls: ['./form-rol.component.css']
})
export class FormRolComponent implements OnInit, OnDestroy {
  validateForm: FormGroup;
  private rol = new Rol();
  subscription: Subscription;

  submitForm(): void {
    for (const i in this.validateForm.controls) {
      this.validateForm.controls[i].markAsDirty();
      this.validateForm.controls[i].updateValueAndValidity();
    }
  }

  constructor(private fb: FormBuilder,
    private servicioLocal: LocalService, private servicioRol: RolService) {
    this.subscription = this.servicioLocal.obtenerAccion().subscribe(accion => {
      this.servicioRol.saveRoles(this.rol).subscribe();
      console.log(this.validateForm);
    });
  }


  ngOnInit(): void {
    this.validateForm = this.fb.group({
      nombre: [null, [Validators.required]],
      estado: [null, [Validators.required]]
    });
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }
}
