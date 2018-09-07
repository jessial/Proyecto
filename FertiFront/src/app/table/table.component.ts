import { Component, OnInit } from '@angular/core';
import { TipoCultivoService } from '../servicios/tipo-cultivo.service';
import { TipoCultivo } from '../calses_dominio/tipo-cultivo';


@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  tiposCultivo: TipoCultivo[];
  i = 1;
  editCache = {};
  dataSet = [];

  constructor(private tipoCultivoService: TipoCultivoService) {}

  addRow(): void {
    this.i++;
    this.dataSet = [ ...this.dataSet, {
      codigo    : `${this.i}`,
      variedad  : ``,
      nombre    : '',
      estado    : false
    } ];
    this.updateEditCache(true);
  }

  deleteRow(i: string): void {
    const dataSet = this.dataSet.filter(d => d.codigo !== i);
    this.dataSet = dataSet;
  }

  startEdit(key: string): void {
    this.editCache[ key ].edit = true;
  }

  finishEdit(key: string): void {
    this.editCache[ key ].edit = false;
    this.dataSet.find(item => item.codigo === key).variedad = this.editCache[ key ].variedad;
    this.dataSet.find(item => item.codigo === key).nombre = this.editCache[ key ].nombre;
  }

  updateEditCache(edit: boolean): void {
    this.dataSet.forEach(item => {
      if (!this.editCache[ item.codigo ]) {
        this.editCache[ item.codigo ] = {
          edit: edit,
          data: item
        };
      }
    });
  }

  ngOnInit(): void {
    this.getTiposCultivo();
    console.log(this.tiposCultivo[0].nombre);
    this.updateEditCache(false);
  }

  getTiposCultivo(): void {
    this.tipoCultivoService.getTiposCultivo()
    .subscribe(tiposCultivo => this.tiposCultivo = tiposCultivo);
  }

}
