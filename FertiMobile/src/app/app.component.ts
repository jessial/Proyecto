import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { SplashScreen } from '@ionic-native/splash-screen/ngx';
import { StatusBar } from '@ionic-native/status-bar/ngx';
import { AlertController, MenuController, NavController, Platform } from '@ionic/angular';
import { SeguridadService } from './servicios/seguridad.service';


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
    private statusBar: StatusBar, private alertController: AlertController, private seguridadService: SeguridadService,
    private router: Router, private navCtrl: NavController, public menu: MenuController) {
    this.initializeApp();
  }

  initializeApp() {
    this.platform.ready().then(() => {
      this.statusBar.styleDefault();
      this.splashScreen.hide();
    });

    this.platform.backButton.subscribe(() => {
      if (this.router.routerState.snapshot.url === '/inicio-sesion') {
        this.confirmarCerrarAplicacion();
      } else if (this.router.routerState.snapshot.url === '/registro-usuario') {
        this.navCtrl.navigateRoot('inicio-sesion');
      } else {
        this.navCtrl.navigateRoot('home');
      }
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
          // this.router.navigateByUrl('/', { replaceUrl: true });
          this.seguridadService.logout();
        }
      }]
    });
    await alert.present();
  }

  async confirmarCerrarAplicacion() {
    const alert = await this.alertController.create({
      header: 'Cerrar aplicación',
      message: '¿Desea cerrar la aplicación?',
      buttons: [{ text: 'Cancelar' }, {
        text: 'Aceptar', handler: () => {
          // this.router.navigateByUrl('/', { replaceUrl: true });
          navigator['app'].exitApp();
        }
      }]
    });
    await alert.present();
  }
}
