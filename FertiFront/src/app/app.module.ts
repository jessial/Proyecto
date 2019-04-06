import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule  } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgZorroAntdModule, NZ_I18N, en_US } from 'ng-zorro-antd';
import { registerLocaleData } from '@angular/common';
import en from '@angular/common/locales/en';
import { MenuComponent } from './menu/menu.component';
import { TableComponent } from './table_tipos_cultivo/table.component';
import { NZ_NOTIFICATION_CONFIG } from 'ng-zorro-antd';
import { FormComponent } from './form_tipo_cultivo/form.component';
import { AppRoutingModule } from './routing_menu/app-routing.module';
import { DrawerComponent } from './drawer/drawer.component';
import { TableRolComponent } from './table-rol/table-rol.component';
import { FormRolComponent } from './form-rol/form-rol.component';
import { SeguridadModule } from './seguridad/seguridad.module';
import { FormRequerimientosCultivoComponent } from './form-requerimientos-cultivo/form-requerimientos-cultivo.component';
import { FormTipoFuenteComponent } from './form-tipo-fuente/form-tipo-fuente.component';
import { TableRequerimientosCultivoComponent } from './table-requerimientos-cultivo/table-requerimientos-cultivo.component';
import { TableTipoFuenteComponent } from './table-tipo-fuente/table-tipo-fuente.component';
import { TableFuenteComponent } from './table-fuente/table-fuente.component';
import { FormTipoFuenteEdicionComponent } from './form-tipo-fuente-edicion/form-tipo-fuente-edicion.component';
import { FormRequerimientosCultivoEdicionComponent } from './form-requerimientos-cultivo-edicion/form-requerimientos-cultivo-edicion.component';

registerLocaleData(en);

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    TableComponent,
    FormComponent,
    DrawerComponent,
    TableRolComponent,
    FormRolComponent,
    FormRequerimientosCultivoComponent,
    FormTipoFuenteComponent,
    TableRequerimientosCultivoComponent,
    TableTipoFuenteComponent,
    TableFuenteComponent,
    FormTipoFuenteEdicionComponent,
    FormRequerimientosCultivoEdicionComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    NgZorroAntdModule,
    ReactiveFormsModule,
    SeguridadModule,
    AppRoutingModule
  ],
  exports: [
    
  ],
  providers: [{ provide: NZ_I18N, useValue: en_US }, 
    { provide: NZ_NOTIFICATION_CONFIG, useValue: { 
      nzTop         : '24px',
      nzBottom      : '24px',
      nzPlacement   : 'topRight',
      nzDuration    : 9000,
      nzMaxStack    : 5,
      nzPauseOnHover: true,
      nzAnimate     : true }}],
  bootstrap: [AppComponent]
})
export class AppModule { }
