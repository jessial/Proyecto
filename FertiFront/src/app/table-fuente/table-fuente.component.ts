import { Component, OnInit } from '@angular/core';
import { FuenteService } from '../servicios/fuente.service';
import { Fuente } from '../clases_dominio/fuente';
import { NzModalRef, NzModalService } from 'ng-zorro-antd';

@Component({
  selector: 'app-table-fuente',
  templateUrl: './table-fuente.component.html',
  styleUrls: ['./table-fuente.component.css']
})
export class TableFuenteComponent implements OnInit {

  editCache = {};
  dataSet = [];
  modalConfirmacionEliminado: NzModalRef;

  constructor(private fuenteServicio: FuenteService, private modalEliminar: NzModalService) { }

  ngOnInit(): void {
    this.fuenteServicio.cargarDatos();
    this.getFuentes();
  }

  getFuentes(): void {
    this.fuenteServicio.getFuentes()
      .subscribe(result => {
        this.dataSet = result;
      }
      );
  }

  cambiarEstado(fuente: Fuente) {
    this.fuenteServicio.updateOrCreate(fuente).subscribe();
  }

  editarRegistro(fuente: Fuente) {
    this.fuenteServicio.editarFuente(fuente);
  }

  crearRegistro() {
    this.fuenteServicio.editarFuente(new Fuente());
  }

  borrarFuente(fuente: Fuente) {
    this.modalConfirmacionEliminado = this.modalEliminar.confirm({
      nzTitle: 'Eliminar',
      nzContent: '¿Desea eliminar la fuente?',
      nzOkText: 'Aceptar',
      nzCancelText: 'Cancelar',
      nzOnOk: () => {
        this.fuenteServicio.deleteFuente(fuente);
      }
    });
  }


}
