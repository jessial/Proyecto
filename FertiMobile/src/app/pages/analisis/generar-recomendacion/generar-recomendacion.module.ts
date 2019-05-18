import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { GenerarRecomendacionPage } from './generar-recomendacion.page';

const routes: Routes = [
  {
    path: '',
    component: GenerarRecomendacionPage
  }
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RouterModule.forChild(routes),
    ReactiveFormsModule
  ],
  declarations: [GenerarRecomendacionPage]
})
export class GenerarRecomendacionPageModule { }
