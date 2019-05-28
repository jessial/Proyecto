import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { UtilidadService } from '../../servicios/utilidad.service';
import { SeguridadService } from '../servicios/seguridad.service';


@Injectable({
  providedIn: 'root'
})
export class GuardSeguridadGuard implements CanActivate {
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
      if(this.seguridadService.isAuthenticated() && !this.esTokenExpirado()){
        return true;
      }
      this.router.navigate(['/login']);
    return false;
  }

  constructor(private utilidad: UtilidadService, private seguridadService: SeguridadService, private router : Router) { }

  esTokenExpirado(): boolean{
    let token = sessionStorage.getItem('token');;
    let payload = this.seguridadService.obtenerDatosToken(token);
    let now = new Date().getTime() / 1000;
    if(payload.exp < now){
      return true;
    }
    return false;
  }
}
