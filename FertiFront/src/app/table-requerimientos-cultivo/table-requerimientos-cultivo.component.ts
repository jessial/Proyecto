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
    this.getRequerimientos();
  }

  moverIzquierda(evento): void {
    const trElements = document.querySelectorAll('.table-content tr')
    Array.from(trElements).forEach(tr => {
      (tr.childNodes[this.tableI] as Element).classList.add("oculto");
    });
    this.tableI = this.tableI < trElements[0].childNodes.length - 1 ? this.tableI + 1 : this.tableI;
  }

  moverDerecha(evento): void {
    Array.from(document.querySelectorAll('.table-content tr')).forEach(tr => {
      (tr.childNodes[this.tableI] as Element).classList.remove("oculto");
    });
    this.tableI = this.tableI > 1 ? this.tableI - 1 : this.tableI;
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
