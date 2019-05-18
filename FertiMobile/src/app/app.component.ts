import { Component } from '@angular/core';

import { Platform, AlertController, MenuController } from '@ionic/angular';
import { SplashScreen } from '@ionic-native/splash-screen/ngx';
import { StatusBar } from '@ionic-native/status-bar/ngx';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html'
})
export class AppComponent {
  public appPages = [
    {
      title: 'Finca',
      url: '/lista-lugar',
      icon: 'pin'
    },
    {
      title: 'Parcela',
      url: '/lista-parcela',
      icon: 'grid'
    },
    {
      title: 'Análisis',
      url: '/lista-analisis',
      icon: 'stats'
    }
  ];

  constructor(private platform: Platform, private splashScreen: SplashScreen,
    private statusBar: StatusBar, private alertController: AlertController,
    private router: Router, public menu: MenuController) {
    this.initializeApp();
  }

  initializeApp() {
    this.platform.ready().then(() => {
      this.statusBar.styleDefault();
      this.splashScreen.hide();
    });
  }

  cerrarSesion() {
    this.menu.close();
    this.confirmarCerrarSesion();
  }

  async confirmarCerrarSesion() {
    const alert = await this.alertController.create({
      header: 'Cerrar sesión',
      message: '¿Desea finalizar la sesión?',
      buttons: [{ text: 'Cancelar' }, {
        text: 'Aceptar', handler: () => {
          this.router.navigateByUrl('/');
        }
      }]
    });
    await alert.present();
  }
}
