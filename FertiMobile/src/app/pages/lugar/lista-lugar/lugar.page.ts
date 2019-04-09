import { Component, OnInit } from '@angular/core';
import { PopoverController, AlertController } from '@ionic/angular';
import { Lugar } from 'src/app/dominio/lugar';
import { PopoverOpcionesComponent } from '../../popover-opciones/popover-opciones.component';
import { Router } from '@angular/router';
import { LugarService } from 'src/app/servicios/lugar.service';

@Component({
  selector: 'app-lugar',
  templateUrl: './lugar.page.html',
  styleUrls: ['./lugar.page.scss'],
})
export class LugarPage implements OnInit {

  lugares: Lugar[] = [];

  constructor(public popoverController: PopoverController, private alertController: AlertController,
    private router: Router, private lugarServicio: LugarService) { }

  ngOnInit() {
    this.lugarServicio.cargarDatos();
    this.lugarServicio.getLugares().subscribe(lugares => {
      this.lugares = lugares;
    });
  }

  async mostrarPopover(evento: any, lugar: Lugar) {
    const popover = await this.popoverController.create({
      component: PopoverOpcionesComponent,
      event: evento,
      mode: 'ios',
      translucent: true
    });
    await popover.present();

    const { data } = await popover.onDidDismiss();
    if (data && data.accion === 'editar') {
      this.lugarServicio.editarLugar(lugar);
      this.router.navigateByUrl('editar-lugar');
    } else if (data && data.accion === 'eliminar') {
      this.confirmarEliminacion(lugar);
    }
  }

  agregarLugar() {
    this.router.navigateByUrl('agregar-lugar');
  }

  async confirmarEliminacion(lugar: Lugar) {
    const alert = await this.alertController.create({
      header: 'Eliminar',
      message: '¿Desea eliminar el lugar?',
      buttons: [{ text: 'Cancelar' }, {
        text: 'Aceptar', handler: () => {
          this.lugarServicio.deleteLugar(lugar);
        }
      }]
    });
    await alert.present();
  }

}
