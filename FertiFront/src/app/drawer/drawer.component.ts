import { Component } from '@angular/core';
import { LocalService } from '../servicios/local.service';

@Component({
  selector: 'app-drawer',
  templateUrl: './drawer.component.html',
  styleUrls: ['./drawer.component.css']
})

export class DrawerComponent {
  visible = false;
  childrenVisible = false;
  formulario: string;
  data: any;

  constructor(private servicioLocal: LocalService) { }

  submit() {
    this.servicioLocal.enviarAccion('clic');
  }

  open(formulario: string): void {
    this.formulario = formulario;
    this.visible = true;
  }

  close(): void {
    this.visible = false;
  }

  openChildren(): void {
    this.childrenVisible = true;
  }

  closeChildren(): void {
    this.childrenVisible = false;
  }

}
