import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    loadChildren: './pages/home/home.module#HomePageModule'
  },
  {
    path: 'lista-lugar',
    loadChildren: './pages/lugar/lista-lugar/lugar.module#LugarPageModule'
  },
  {
    path: 'lista-parcela',
    loadChildren: './pages/parcela/lista-parcela/parcela.module#ParcelaPageModule'
  },
  {
    path: 'lista-analisis',
    loadChildren: './pages/analisis/lista-analisis/analisis.module#AnalisisPageModule'
  },
  { path: 'agregar-lugar', loadChildren: './pages/lugar/agregar-lugar/agregar-lugar.module#AgregarLugarPageModule' },
  { path: 'editar-lugar', loadChildren: './pages/lugar/editar-lugar/editar-lugar.module#EditarLugarPageModule' },
  { path: 'agregar-parcela', loadChildren: './pages/parcela/agregar-parcela/agregar-parcela.module#AgregarParcelaPageModule' },
  { path: 'editar-parcela', loadChildren: './pages/parcela/editar-parcela/editar-parcela.module#EditarParcelaPageModule' }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
