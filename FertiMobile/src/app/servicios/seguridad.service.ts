import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { UsuarioSeguridad } from '../dominio/usuario-seguridad';
import { Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { catchError } from 'rxjs/operators';
import { NavController, MenuController } from '@ionic/angular';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class SeguridadService {

  private loginUrl = `${environment.URL_BASE}/login`;
  private router: Router;

  constructor(private http: HttpClient, private navCtrl: NavController,
    private menu: MenuController) { }

  public getAuth(usuario: UsuarioSeguridad): void {
    this.http.post<Observable<boolean>>(this.loginUrl, usuario).subscribe(isValid => {
      if (isValid) {
        sessionStorage.setItem(
          'token',
          btoa(usuario.cedula + ':' + usuario.password)
        );
        this.menu.enable(true);
        this.navCtrl.navigateRoot('home');
        return true;
      } else {
        return false;
      }
    });
  }
  public getAuth1(usuario: UsuarioSeguridad): void {
    this.http.post<Observable<boolean>>(this.loginUrl, usuario, httpOptions).pipe(catchError(e => {
      this.noAutorizado(e);
      return throwError(e);
    }));
  }

  private noAutorizado(e): boolean {
    if (e.status === 401 || e.status === 403) {
      this.router.navigate(['/login']);
      return true;
    }
    return false;
  }

}
