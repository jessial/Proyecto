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
  mapOfExpandData: { [key: string]: boolean } = {};

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
}
