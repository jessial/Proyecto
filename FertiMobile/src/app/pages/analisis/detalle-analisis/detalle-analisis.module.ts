import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { DetalleAnalisisPage } from './detalle-analisis.page';

const routes: Routes = [
  {
    path: '',
    component: DetalleAnalisisPage
  }
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RouterModule.forChild(routes)
  ],
  declarations: [DetalleAnalisisPage]
})
export class DetalleAnalisisPageModule {}
