import { Component, OnInit } from '@angular/core';
import { Rol } from '../clases_dominio/rol';
import { RolService } from '../servicios/rol.service'
import { NzModalRef, NzModalService } from 'ng-zorro-antd';

@Component({
  selector: 'app-table-rol',
  templateUrl: './table-rol.component.html',
  styleUrls: ['./table-rol.component.css']
})
export class TableRolComponent implements OnInit {

  editCache = {};
  dataSet = [];
  modalConfirmacionEliminado: NzModalRef;

  constructor(private rolService: RolService, private modalEliminar: NzModalService) { }

  ngOnInit(): void {
    this.rolService.cargarDatos();
    this.getRoles();
  }

  getRoles(): void {
    this.rolService.getRoles()
      .subscribe(result => {
        this.dataSet = result;
      }
      );
  }

  cambiarEstado(rol: Rol) {
    this.rolService.updateOrCreate(rol)
      .subscribe();
  }

  editarRegistro(rol: Rol) {
    this.rolService.editarRoles(rol);
  }

  crearRegistro() {
    this.rolService.editarRoles(new Rol());
  }

  borrarRol(rol: Rol) {
    this.modalConfirmacionEliminado = this.modalEliminar.confirm({
      nzTitle: 'Eliminar',
      nzContent: '¿Desea eliminar el rol?',
      nzOkText: 'Aceptar',
      nzCancelText: 'Cancelar',
      nzOnOk: () => {
        this.rolService.deleteRoles(rol);
      }
    });
  }
}
