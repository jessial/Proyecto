import { Component, OnInit } from '@angular/core';
import { RequerimientoCultivoService } from '../servicios/requerimiento-cultivo.service';
import { RequerimientoCultivo } from '../clases_dominio/requerimiento-cultivo';
import { NzModalService, NzModalRef } from 'ng-zorro-antd';

@Component({
  selector: 'app-table-requerimientos-cultivo',
  templateUrl: './table-requerimientos-cultivo.component.html',
  styleUrls: ['./table-requerimientos-cultivo.component.css']
})
export class TableRequerimientosCultivoComponent implements OnInit {

  editCache = {};
  dataSet = [];
  modalConfirmacionEliminado: NzModalRef;

  constructor(private requerimientoService: RequerimientoCultivoService, private modalEliminar: NzModalService) { }

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

  borrarRequerimientoCultivo(requerimiento: RequerimientoCultivo) {
    this.modalConfirmacionEliminado = this.modalEliminar.confirm({
      nzTitle: 'Eliminar',
      nzContent: '¿Desea eliminar el requerimiento cultivo?',
      nzOkText: 'Aceptar',
      nzCancelText: 'Cancelar',
      nzOnOk: () => {
        this.requerimientoService.deleteRequerimientoCultivo(requerimiento);
      }
    });
  }
}
