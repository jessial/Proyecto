import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AlertController, PopoverController } from '@ionic/angular';
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
    private router: Router, private parcelaServicio: ParcelaService) { }

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
    const popover = await this.popoverController.create({
      component: PopoverOpcionesComponent,
      componentProps: { habilitadoEdicion },
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
