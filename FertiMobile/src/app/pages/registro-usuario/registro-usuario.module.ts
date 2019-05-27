import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { RegistroUsuarioPage } from './registro-usuario.page';

const routes: Routes = [
  {
    path: '',
    component: RegistroUsuarioPage
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
  declarations: [RegistroUsuarioPage]
})
export class RegistroUsuarioPageModule { }
