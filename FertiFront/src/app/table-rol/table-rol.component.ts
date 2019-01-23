import { Component, OnInit } from '@angular/core';
import { Rol } from '../calses_dominio/rol';
import { RolService } from '../servicios/rol.service'

@Component({
  selector: 'app-table-rol',
  templateUrl: './table-rol.component.html',
  styleUrls: ['./table-rol.component.css']
})
export class TableRolComponent implements OnInit {
  i = 1;
  editCache = {};
  dataSet = [];

  constructor(private rolService: RolService) { }

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

  cambiarRegistro(rol: Rol) {
    this.rolService.saveRoles(rol)
      .subscribe();
  }

  editarRegistro(rol: Rol) {
    this.rolService.saveRoles(rol);
  }

  crearRegistro() {
    this.rolService.saveRoles(new Rol());
  }
}
