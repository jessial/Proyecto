import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AlertController, PopoverController, ActionSheetController } from '@ionic/angular';
import { Lugar } from 'src/app/dominio/lugar';
import { LugarService } from 'src/app/servicios/lugar.service';
import { PopoverOpcionesComponent } from '../../popover-opciones/popover-opciones.component';

@Component({
  selector: 'app-lugar',
  templateUrl: './lugar.page.html',
  styleUrls: ['./lugar.page.scss'],
})
export class LugarPage implements OnInit {

  lugares: Lugar[] = [];

  constructor(public popoverController: PopoverController, private alertController: AlertController,
    private router: Router, private lugarServicio: LugarService,
    public actionSheetController: ActionSheetController) { }

  ngOnInit() {
    this.lugarServicio.cargarDatos();
    this.lugarServicio.getLugares().subscribe(lugares => {
      this.lugares = lugares;
    });
  }

  async mostrarPopover(lugar: Lugar) {
    const actionSheet = await this.actionSheetController.create({
      buttons: [{
        text: 'Eliminar',
        role: 'destructive',
        icon: 'trash',
        handler: () => {
          this.confirmarEliminacion(lugar);
        }
      }, {
        text: 'Editar',
        icon: 'create',
        handler: () => {
          this.lugarServicio.editarLugar(lugar);
          this.router.navigateByUrl('editar-lugar');
        }
      }, {
        text: 'Cancelar',
        icon: 'close',
        role: 'cancel'
      }]
    });
    await actionSheet.present();
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
