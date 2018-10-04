import { Component, OnInit, Output, EventEmitter } from '@angular/core';
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
  dataSet  = [];

  @Output() editDate = new EventEmitter();
  
  constructor(private tipoCultivoService: TipoCultivoService) {}

  addRow(): void {
   
  }

  deleteRow(i: string): void {
    
  }

  startEdit(key: string): void {
   
  }

  finishEdit(key: string): void {
    
  }

  updateEditCache(edit: boolean): void {
    
  }

  ngOnInit(): void {
    this.getTiposCultivo();
  }

  getTiposCultivo(): void {
    this.tipoCultivoService.getTiposCultivo()
      .subscribe(result => {
        this.dataSet = result;
      }
      );
  }

  cambiarRegistro(tipoCultivo: TipoCultivo){
    this.tipoCultivoService.updateTiposCultivo(tipoCultivo)
    .subscribe();
  }

  editarRegistro(tipoCultivo: TipoCultivo) {
    this.editDate.emit(tipoCultivo);
  }

}
