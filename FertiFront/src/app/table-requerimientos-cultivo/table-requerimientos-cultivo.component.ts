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
  editCache = {};
  dataSet = [];

  constructor(private requerimientoService: RequerimientoCultivoService) { }

  ngOnInit(): void {
    this.getRequerimientos();
  }

  getRequerimientos(): void {
    this.requerimientoService.getRequerimientos()
      .subscribe(result => {
        this.dataSet = result;
      }
      );
  }

  cambiarRegistro(requerimiento: RequerimientoCultivo) {
    this.requerimientoService.updateRequerimientos(requerimiento)
      .subscribe();
  }
}
