import { AnalisisService } from './../../../servicios/analisis.service';
import { DTOAnalisis } from 'src/app/dto/dto-analisis';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-detalle-analisis',
  templateUrl: './detalle-analisis.page.html',
  styleUrls: ['./detalle-analisis.page.scss'],
})
export class DetalleAnalisisPage implements OnInit {

  analisisADetallar: DTOAnalisis;

  constructor(private analisisServicio: AnalisisService, private router: Router) { }

  ngOnInit() {
    this.analisisADetallar = this.analisisServicio.getDetalleAnalisis();
  }

  generarRecomendacion() {
    this.router.navigateByUrl('generar-recomendacion');
  }

}
