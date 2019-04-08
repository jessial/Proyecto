import { NavParams, PopoverController } from '@ionic/angular';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-popover-opciones',
  templateUrl: './popover-opciones.component.html',
  styleUrls: ['./popover-opciones.component.scss'],
})
export class PopoverOpcionesComponent implements OnInit {

  constructor(private popoverController: PopoverController) { }

  ngOnInit() {
  }

  public accion(accion: string) {
    this.popoverController.dismiss({
      accion: accion
    });
  }

  cerrar() {
    this.popoverController.dismiss();
  }

}
