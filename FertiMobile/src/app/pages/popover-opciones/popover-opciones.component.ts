import { Component, OnInit } from '@angular/core';
import { NavParams, PopoverController } from '@ionic/angular';

@Component({
  selector: 'app-popover-opciones',
  templateUrl: './popover-opciones.component.html',
  styleUrls: ['./popover-opciones.component.scss'],
})
export class PopoverOpcionesComponent implements OnInit {

  habilitadoEdicion = true;

  constructor(private popoverController: PopoverController, navParams: NavParams) {
    this.habilitadoEdicion = navParams.get('habilitadoEdicion');
  }

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
