import { Component, OnInit } from '@angular/core';
import { ParcelaService } from '../servicios/parcela.service';

@Component({
  selector: 'app-table-parcela',
  templateUrl: './table-parcela.component.html',
  styleUrls: ['./table-parcela.component.css']
})
export class TableParcelaComponent implements OnInit {

  editCache = {};
  dataSet = [];

  constructor(private parcelaServicio: ParcelaService) { }

  ngOnInit() {
    this.parcelaServicio.cargarDatos();
    this.getParcelas();
  }

  getParcelas(): void {
    this.parcelaServicio.getParcelas().subscribe(result => {
      this.dataSet = result;
    });
  }

}
