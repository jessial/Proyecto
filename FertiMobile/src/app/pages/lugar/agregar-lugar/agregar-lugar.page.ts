import { LugarService } from './../../../servicios/lugar.service';
import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { LoadingController } from '@ionic/angular';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Lugar } from 'src/app/dominio/lugar';

@Component({
  selector: 'app-agregar-lugar',
  templateUrl: './agregar-lugar.page.html',
  styleUrls: ['./agregar-lugar.page.scss'],
})
export class AgregarLugarPage implements OnInit {

  formularioAgregarLugar: FormGroup;
  enviado = false;
  carga: any;

  constructor(private fb: FormBuilder, private location: Location,
    public loadingController: LoadingController, private lugarServicio: LugarService) { }

  ngOnInit() {
    this.formularioAgregarLugar = this.fb.group({
      nombre: [null, [Validators.required]],
      ubicacion: [null, [Validators.required]]
    });
  }


  agregar() {
    this.enviado = true;
    if (this.formularioAgregarLugar.invalid) {
      return null;
    }
    this.mostrarCarga().then(_ => {
      const lugar = new Lugar();
      lugar.nombre = this.f.nombre.value;
      lugar.ubicacion = this.f.ubicacion.value;
      lugar.usuario = {
        apellido: 'londono', cedula: 1094, codigoRol: 1, email: 'asd@asd.co',
        nombre: 'Cristian', password: '1234', telefono: 123
      };
      this.lugarServicio.updateOrCreate(lugar).subscribe(resp => {
        this.lugarServicio.cargarDatos();
        this.location.back();
        this.ocultarCarga();
      });
    });
  }

  async mostrarCarga() {
    this.carga = await this.loadingController.create({
      message: 'Agregando...'
    });
    return this.carga.present();
  }

  ocultarCarga() {
    this.carga.dismiss();
  }

  get f() { return this.formularioAgregarLugar.controls; }

}