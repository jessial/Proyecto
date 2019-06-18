import { Component, OnInit } from '@angular/core';
import { TipoCultivoService } from '../servicios/tipo-cultivo.service';
import { TipoCultivo } from '../clases_dominio/tipo-cultivo';
import { NzModalRef, NzModalService } from 'ng-zorro-antd';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  editCache = {};
  dataSet = [];
  modalConfirmacionEliminado: NzModalRef;

  constructor(private tipoCultivoService: TipoCultivoService, private modalEliminar: NzModalService) { }

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
    this.modalConfirmacionEliminado = this.modalEliminar.confirm({
      nzTitle: 'Eliminar',
      nzContent: '¿Desea eliminar el tipo de fuente?',
      nzOkText: 'Aceptar',
      nzCancelText: 'Cancelar',
      nzOnOk: () => {
        this.tipoCultivoService.deleteTipoCultivo(tipoCultivo);
      }
    });

  }


}
