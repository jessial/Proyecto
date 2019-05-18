import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  slides: { imagen: string, titulo: string, descripcion: string }[] = [
    {
      imagen: '/assets/slides/aguacate.svg',
      titulo: 'Título de la imagen',
      descripcion: 'Describiendo la imagen 1... '
    },
    {
      imagen: '/assets/slides/elemento.png',
      titulo: 'Título de la imagen',
      descripcion: 'Describiendo la imagen 1... '
    },
    {
      imagen: '/assets/slides/calculo.png',
      titulo: 'Título de la imagen',
      descripcion: 'Describiendo la imagen 1... '
    }
  ];

}
