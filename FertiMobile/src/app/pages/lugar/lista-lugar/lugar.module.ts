import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { LugarPage } from './lugar.page';
import { PopoverOpcionesComponent } from '../../popover-opciones/popover-opciones.component';


const routes: Routes = [
  {
    path: '',
    component: LugarPage
  }
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RouterModule.forChild(routes)
  ],
  declarations: [LugarPage, PopoverOpcionesComponent],
  entryComponents: [PopoverOpcionesComponent]
})
export class LugarPageModule { }
