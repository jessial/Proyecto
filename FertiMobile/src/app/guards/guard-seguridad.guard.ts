import { Injectable } from '@angular/core';
import { CanActivate } from '@angular/router';
import { NavController } from '@ionic/angular';
import { Observable } from 'rxjs';
import { SeguridadService } from '../servicios/seguridad.service';


@Injectable({
  providedIn: 'root'
})
export class GuardSeguridadGuard implements CanActivate {

  constructor(private seguridadService: SeguridadService, private navCtrl: NavController) { }

  canActivate(): Observable<boolean> | Promise<boolean> | boolean {
    if (this.seguridadService.isAuthenticated() && !this.esTokenExpirado()) {
      return true;
    }
    this.navCtrl.navigateRoot('/');
    return false;
  }

  esTokenExpirado(): boolean {
    const token = sessionStorage.getItem('token');
    const payload = this.seguridadService.obtenerDatosToken(token);
    const now = new Date().getTime() / 1000;
    if (payload.exp < now) {
      return true;
    }
    return false;
  }
}
