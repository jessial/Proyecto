import { Router } from '@angular/router';
import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  constructor(private router: Router) {
  }

  slides: { imagen: string, titulo: string, descripcion: string, url: string }[] = [
    {
      imagen: '/assets/slides/aguacate.svg',
      titulo: 'FertiApp',
      descripcion: 'Para facilitar tu vida en el campo.',
      url: '/home'
    },
    {
      imagen: '/assets/slides/finca.png',
      titulo: 'Finca',
      descripcion: 'En esta sección podrás registrar tus fincas.',
      url: 'lista-lugar'
    },
    {
      imagen: '/assets/slides/cultivo.png',
      titulo: 'Parcelas',
      descripcion: 'En esta sección podrás ingresar las parcelas o lotes de tu finca.',
      url: 'lista-parcela'
    },
    {
      imagen: '/assets/slides/triple15.png',
      titulo: 'Recomendaciones',
      descripcion: 'En esta sección podrás ver las recomendaciones de fertilización para tu cultivo.',
      url: 'lista-analisis'
    },
    {
      imagen: '/assets/slides/analisis.png',
      titulo: 'Análisis',
      descripcion: 'En esta sección podrás ingresar los datos de tu análisis de suelos.',
      url: 'lista-analisis'
    }
  ];

  irASeccion(url: string) {
    this.router.navigateByUrl(url);
  }

}
