import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormComponent } from './form_tipo_cultivo/form.component';
import { TableComponent } from './table_tipos_cultivo/table.component';
import { TableRolComponent } from './table-rol/table-rol.component';
import { TableRequerimientosCultivoComponent } from './table-requerimientos-cultivo/table-requerimientos-cultivo.component';
import { TableTipoFuenteComponent } from './table-tipo-fuente/table-tipo-fuente.component';
import { TableFuenteComponent } from './table-fuente/table-fuente.component';


const routes: Routes = [
  { path: 'ingreso_tipo_cultivo', component: FormComponent },
  { path: 'lista_tipo_cultivo', component: TableComponent },
  { path: 'lista_roles', component: TableRolComponent },
  { path: 'lista_requerimientos', component: TableRequerimientosCultivoComponent },
  { path: 'lista_tipo_fuente', component: TableTipoFuenteComponent },
  { path: 'lista_fuente', component: TableFuenteComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
