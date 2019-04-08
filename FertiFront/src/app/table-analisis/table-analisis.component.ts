import { Component, OnInit } from '@angular/core';
import { AnalisisService } from '../servicios/analisis.service';

@Component({
  selector: 'app-table-analisis',
  templateUrl: './table-analisis.component.html',
  styleUrls: ['./table-analisis.component.css']
})
export class TableAnalisisComponent implements OnInit {

  editCache = {};
  dataSet = [];
  i = 1;
  tableI = 1;

  constructor(private analisisServicio: AnalisisService) { }

  ngOnInit() {
    this.analisisServicio.cargarDatos();
    this.getAnalisis();
  }

  getAnalisis(): void {
    this.analisisServicio.getAnalisis().subscribe(result => {
      this.dataSet = result;
    });
  }

  /*moverIzquierda(evento): void {
    const trElements = document.querySelectorAll('.table-content tr')
    trElements.forEach(tr => {
    tr.childNodes[this.tableI].classList.add("oculto");
    });
    this.tableI = this.tableI < trElements[0].childNodes.length - 1 ? this.tableI + 1 : this.tableI;
  }
    
    moverDerecha(evento): void {
    document.querySelectorAll('.table-content tr').forEach(tr => {
    tr.childNodes[this.tableI].classList.remove("oculto");
    });
    this.tableI = this.tableI > 1 ? this.tableI - 1 : this.tableI;
  }*/

}
