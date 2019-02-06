import { Component, OnInit } from '@angular/core';
import { RequerimientoCultivoService } from '../servicios/requerimiento-cultivo.service';
import { RequerimientoCultivo } from '../calses_dominio/requerimiento-cultivo';

@Component({
  selector: 'app-table-requerimientos-cultivo',
  templateUrl: './table-requerimientos-cultivo.component.html',
  styleUrls: ['./table-requerimientos-cultivo.component.css']
})
export class TableRequerimientosCultivoComponent implements OnInit {

  i = 1;
  tableI = 1;
  editCache = {};
  dataSet = [];

  constructor(private requerimientoService: RequerimientoCultivoService) { }

  ngOnInit(): void {
    this.requerimientoService.cargarDatos();
    this.getRequerimientos();
  }

  getRequerimientos(): void {
    this.requerimientoService.getRequerimientosPorCultivo()
      .subscribe(result => {
        this.dataSet = result;
      }
      );
  }

  cambiarEstado(requerimientoCultivo: RequerimientoCultivo) {
    this.requerimientoService.updateOrCreate(requerimientoCultivo).subscribe();
  }

  editarRegistro(requerimientoCultivo: RequerimientoCultivo) {
    this.requerimientoService.editarRequerimiento(requerimientoCultivo);
  }

  crearRegistro() {
    this.requerimientoService.editarRequerimiento(new RequerimientoCultivo());
  }
}
