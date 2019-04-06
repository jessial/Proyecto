import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormComponent } from '../form_tipo_cultivo/form.component';
import { TableComponent } from '../table_tipos_cultivo/table.component';
import { TableRolComponent } from '../table-rol/table-rol.component';
import { MenuComponent } from '../menu/menu.component';
import { LoginComponent } from '../seguridad/login/login.component';
import { TableRequerimientosCultivoComponent } from '../table-requerimientos-cultivo/table-requerimientos-cultivo.component';
import { TableTipoFuenteComponent } from '../table-tipo-fuente/table-tipo-fuente.component';
import { TableFuenteComponent } from '../table-fuente/table-fuente.component';
import { TableParcelaComponent } from '../table-parcela/table-parcela.component';
import { TableAnalisisComponent } from '../table-analisis/table-analisis.component';


const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'ingreso_tipo_cultivo', component: FormComponent },
  { path: 'lista_tipo_cultivo', component: TableComponent },
  { path: 'lista_roles', component: TableRolComponent },
  { path: 'menu', component: MenuComponent },
  { path: 'login', component: LoginComponent },
  { path: 'lista_requerimientos', component: TableRequerimientosCultivoComponent },
  { path: 'lista_tipo_fuente', component: TableTipoFuenteComponent },
  { path: 'lista_fuente', component: TableFuenteComponent },
  { path: 'lista_parcelas', component: TableParcelaComponent },
  { path: 'lista_analisis', component: TableAnalisisComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes, { enableTracing: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
