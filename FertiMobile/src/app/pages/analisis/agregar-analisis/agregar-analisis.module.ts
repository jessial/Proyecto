import { ModalAgregarAnalisisComponent } from './../modal-agregar-analisis-component/modal-agregar-analisis-component.component';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { AgregarAnalisisPage } from './agregar-analisis.page';

const routes: Routes = [
  {
    path: '',
    component: AgregarAnalisisPage
  }
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RouterModule.forChild(routes),
    ReactiveFormsModule,
    HttpClientModule
  ],
  declarations: [AgregarAnalisisPage, ModalAgregarAnalisisComponent],
  entryComponents: [ModalAgregarAnalisisComponent]
})
export class AgregarAnalisisPageModule { }
