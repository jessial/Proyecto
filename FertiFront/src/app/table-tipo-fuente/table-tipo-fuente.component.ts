import { Component, OnInit } from '@angular/core';
import { TipoFuenteService } from '../servicios/tipo-fuente.service';
import { TipoFuente } from '../clases_dominio/tipo-fuente';

@Component({
  selector: 'app-table-tipo-fuente',
  templateUrl: './table-tipo-fuente.component.html',
  styleUrls: ['./table-tipo-fuente.component.css']
})
export class TableTipoFuenteComponent implements OnInit {
  i = 1;
  editCache = {};
  dataSet = [];


  constructor(private tipoFuenteServicio: TipoFuenteService) { }

  ngOnInit(): void {
    this.tipoFuenteServicio.cargarDatos();
    this.getTiposFuente();
  }

  getTiposFuente(): void {
    this.tipoFuenteServicio.getTiposFuente()
      .subscribe(result => {
        this.dataSet = result;
      }
      );
  }
  cambiarEstado(tipoFuente: TipoFuente) {
    this.tipoFuenteServicio.updateOrCreate(tipoFuente)
      .subscribe();
  }

  editarRegistro(tipoFuente: TipoFuente) {
    this.tipoFuenteServicio.editarTipoFuente(tipoFuente);
  }

  crearRegistro() {
    this.tipoFuenteServicio.editarTipoFuente(new TipoFuente());
  }

  borrarTipoFuente(tipoFuente: TipoFuente) {
    this.tipoFuenteServicio.deleteTipoFuente(tipoFuente);
  }
}
