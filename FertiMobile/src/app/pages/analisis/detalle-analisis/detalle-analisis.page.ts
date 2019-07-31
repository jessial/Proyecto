import { DTORecomendacion } from './../../../dto/dto-recomendacion';
import { AnalisisService } from './../../../servicios/analisis.service';
import { DTOAnalisis } from 'src/app/dto/dto-analisis';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RecomendacionService } from 'src/app/servicios/recomendacion.service';

@Component({
  selector: 'app-detalle-analisis',
  templateUrl: './detalle-analisis.page.html',
  styleUrls: ['./detalle-analisis.page.scss'],
})
export class DetalleAnalisisPage implements OnInit {

  analisisADetallar: DTOAnalisis;
  recomendaciones: DTORecomendacion[];

  constructor(private analisisServicio: AnalisisService, private router: Router, private recomendacionServicio: RecomendacionService) { }

  ngOnInit() {
    this.analisisADetallar = this.analisisServicio.getDetalleAnalisis();
    this.recomendacionServicio.cargarDatos(this.analisisADetallar.codigoAnalisis);
    this.recomendacionServicio.getRecomendaciones().subscribe(recomendaciones => {
      this.recomendaciones = recomendaciones;
    });
  }

  generarRecomendacion() {
    this.router.navigateByUrl('generar-recomendacion');
  }

}
