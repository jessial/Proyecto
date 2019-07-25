import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { OlvidoPasswordPage } from './olvido-password.page';

const routes: Routes = [
  {
    path: '',
    component: OlvidoPasswordPage
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
  declarations: [OlvidoPasswordPage]
})
export class OlvidoPasswordPageModule { }
