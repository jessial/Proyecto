import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AlertController, PopoverController, ActionSheetController, ToastController } from '@ionic/angular';
import { Parcela } from 'src/app/dominio/parcela';
import { ParcelaService } from 'src/app/servicios/parcela.service';
import { PopoverOpcionesComponent } from './../../popover-opciones/popover-opciones.component';

@Component({
  selector: 'app-parcela',
  templateUrl: './parcela.page.html',
  styleUrls: ['./parcela.page.scss'],
})
export class ParcelaPage implements OnInit {

  parcelas: Parcela[] = [];
  errorEdicion = false;

  constructor(public popoverController: PopoverController, private alertController: AlertController,
    private router: Router, private parcelaServicio: ParcelaService,
    private actionSheetController: ActionSheetController, private toastController: ToastController) { }

  ngOnInit() {
    this.parcelaServicio.cargarDatos();
    this.parcelaServicio.getParcelas().subscribe(parcelas => {
      this.parcelas = parcelas;
      this.validarSiEsPosibleEditar();
    });
  }

  validarSiEsPosibleEditar() {
    this.errorEdicion = this.parcelas.filter(p => !p.tipoCultivo.estado).length > 0;
  }

  async mostrarPopover(evento: any, parcela: Parcela, habilitadoEdicion: boolean) {
    const actionSheet = await this.actionSheetController.create({
      buttons: [{
        text: 'Eliminar',
        role: 'destructive',
        icon: 'trash',
        handler: () => {
          this.confirmarEliminacion(parcela);
        }
      }, {
        text: 'Editar',
        icon: 'create',
        handler: () => {
          if (habilitadoEdicion) {
            this.parcelaServicio.editarParcela(parcela);
            this.router.navigateByUrl('editar-parcela');
          } else {
            this.mostrarToast('No es posible editar la parcela.');
          }
        }
      }, {
        text: 'Cancelar',
        icon: 'close',
        role: 'cancel'
      }]
    });
    await actionSheet.present();
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

  async mostrarToast(mensaje: string) {
    const toast = await this.toastController.create({
      message: mensaje,
      duration: 2000
    });
    toast.present();
  }
}
