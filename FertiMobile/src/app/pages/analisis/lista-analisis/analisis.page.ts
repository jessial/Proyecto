import { DTOAnalisis } from './../../../dto/dto-analisis';
import { AnalisisService } from './../../../servicios/analisis.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-analisis',
  templateUrl: './analisis.page.html',
  styleUrls: ['./analisis.page.scss'],
})
export class AnalisisPage implements OnInit {

  analisis: DTOAnalisis[] = [];

  constructor(private router: Router, private elementoPorAnalisisServicio: AnalisisService) { }

  ngOnInit() {
    this.elementoPorAnalisisServicio.geBackParcelas().subscribe(analisis => {
      this.analisis = analisis;
    });
  }

  agregarAnalisis() {
    this.router.navigateByUrl('agregar-analisis');
  }

  mostrarDetalle(analisis: DTOAnalisis) {
    this.router.navigateByUrl('detalle-analisis');
    console.log(JSON.stringify(analisis));
  }

}
