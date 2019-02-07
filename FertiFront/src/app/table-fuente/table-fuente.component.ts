import { Component, OnInit } from '@angular/core';
import { FuenteService } from '../servicios/fuente.service';
import { Fuente } from '../calses_dominio/fuente';

@Component({
  selector: 'app-table-fuente',
  templateUrl: './table-fuente.component.html',
  styleUrls: ['./table-fuente.component.css']
})
export class TableFuenteComponent implements OnInit {

  i = 1;
  editCache = {};
  dataSet = [];


  constructor(private fuenteServicio: FuenteService) { }

  ngOnInit(): void {
    this.fuenteServicio.cargarDatos();
    this.getFuentes();
  }

  getFuentes(): void {
    this.fuenteServicio.getFuentes()
      .subscribe(result => {
        this.dataSet = result;
      }
      );
  }

  cambiarEstado(fuente: Fuente) {
    this.fuenteServicio.updateOrCreate(fuente).subscribe();
  }

  editarRegistro(fuente: Fuente) {
    this.fuenteServicio.editarFuente(fuente);
  }

  crearRegistro() {
    this.fuenteServicio.editarFuente(new Fuente());
  }

  borrarCultivo(fuente: Fuente) {
    this.fuenteServicio.deleteFuente(fuente);
  }


}
