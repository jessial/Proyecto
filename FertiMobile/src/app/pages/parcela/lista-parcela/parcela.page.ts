import { PopoverOpcionesComponent } from './../../popover-opciones/popover-opciones.component';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Parcela } from 'src/app/dominio/parcela';
import { PopoverController, AlertController } from '@ionic/angular';
import { ParcelaService } from 'src/app/servicios/parcela.service';

@Component({
  selector: 'app-parcela',
  templateUrl: './parcela.page.html',
  styleUrls: ['./parcela.page.scss'],
})
export class ParcelaPage implements OnInit {

  parcelas: Parcela[] = [];

  constructor(public popoverController: PopoverController, private alertController: AlertController,
    private router: Router, private parcelaServicio: ParcelaService) { }

  ngOnInit() {
    this.parcelaServicio.cargarDatos();
    this.parcelaServicio.getParcelas().subscribe(parcelas => {
      this.parcelas = parcelas;
    });
  }

  async mostrarPopover(evento: any, parcela: Parcela) {
    const popover = await this.popoverController.create({
      component: PopoverOpcionesComponent,
      event: evento,
      mode: 'ios',
      translucent: true
    });
    await popover.present();

    const { data } = await popover.onDidDismiss();
    if (data && data.accion === 'editar') {
      this.parcelaServicio.editarParcela(parcela);
      this.router.navigateByUrl('editar-parcela');
    } else if (data && data.accion === 'eliminar') {
      this.confirmarEliminacion(parcela);
    }
  }

  agregarParcela() {
    this.router.navigateByUrl('agregar-parcela');
  }

  async confirmarEliminacion(parcela: Parcela) {
    const alert = await this.alertController.create({
      header: 'Eliminar',
      message: '¿Desea eliminar la parcela?',
      buttons: [{ text: 'Cancelar' }, {
        text: 'Aceptar', handler: () => {
          this.parcelaServicio.deleteParcela(parcela);
        }
      }]
    });
    await alert.present();
  }
}
