import { Component, OnInit } from '@angular/core';
import { TipoFuenteService } from '../servicios/tipo-fuente.service';
import { TipoFuente } from '../calses_dominio/tipo-fuente';

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
    this.getTipoFuente();
  }

  getTipoFuente(): void {
    this.tipoFuenteServicio.getTipoFuenteBack()
      .subscribe(result => {
        this.dataSet = result;
      }
      );
  }
  cambiarRegistro(tipoFuente: TipoFuente) {
    this.tipoFuenteServicio.updateTipoFuente(tipoFuente)
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
