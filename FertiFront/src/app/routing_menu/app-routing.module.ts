import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormComponent } from '../form_tipo_cultivo/form.component';
import { TableComponent } from '../table_tipos_cultivo/table.component';
import { TableRolComponent } from '../table-rol/table-rol.component';
import { MenuComponent } from '../menu/menu.component';
import { LoginComponent } from '../seguridad/login/login.component';


const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'ingreso_tipo_cultivo', component: FormComponent},
  { path: 'lista_tipo_cultivo', component: TableComponent },
  { path: 'lista_roles', component: TableRolComponent},
  { path: 'menu', component: MenuComponent },
  { path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes, { enableTracing: true } ) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }