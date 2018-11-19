import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { TipoCultivoService } from '../servicios/tipo-cultivo.service';
import { TipoCultivo } from '../calses_dominio/tipo-cultivo';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  i = 1;
  editCache = {};
  dataSet = [];

  constructor(private tipoCultivoService: TipoCultivoService) { }

  ngOnInit(): void {
    this.tipoCultivoService.cargarDatos();
    this.getTiposCultivo();
  }

  getTiposCultivo(): void {
    this.tipoCultivoService.getTiposCultivo()
      .subscribe(result => {
        this.dataSet = result;
      }
      );
  }

  cambiarEstado(tipoCultivo: TipoCultivo) {
    this.tipoCultivoService.updateOrCreate(tipoCultivo).subscribe();
  }

  editarRegistro(tipoCultivo: TipoCultivo) {
    this.tipoCultivoService.editarCultivo(tipoCultivo);
  }

  crearRegistro() {
    this.tipoCultivoService.editarCultivo(new TipoCultivo());
  }

  borrarCultivo(tipoCultivo: TipoCultivo) {
    this.tipoCultivoService.deleteTipoCultivo(tipoCultivo);
  }

}
