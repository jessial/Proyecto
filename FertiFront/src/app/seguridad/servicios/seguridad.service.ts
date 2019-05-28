import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { LocalService } from 'src/app/servicios/local.service';
import { environment } from 'src/environments/environment';
import { UsuarioSeguridad } from '../../clases_dominio/usuarioSeguridad';

const credenciales = btoa('FertiFront' + ':' + 'fertipass');
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/x-www-form-urlencoded',
    'Authorization': 'Basic ' + credenciales
  })
};

@Injectable({
  providedIn: 'root'
})
export class SeguridadService {

  private loginUrl = `${environment.URL_BASE}/oauth/token`;  // URL to web api
  private router: Router;
  private _isLogged: boolean = false;
  private _token: string;

  constructor(private http: HttpClient, private servicioLocal: LocalService) { }

  public getAuth(usuario: UsuarioSeguridad): any {
    const params = new URLSearchParams();
    params.set('grant_type', 'password');
    params.set('username', usuario.nombreUsuario);
    params.set('password', usuario.password);
    return this.http.post<Observable<any>>(this.loginUrl, params.toString(), httpOptions);
  }

  isAuthenticated(): boolean {
    return this._isLogged;
  }

  obtenerDatosToken(token: string): any {
    if (token != null) {
      return JSON.parse(atob(token.split('.')[1]));
    }
    return null;
  }

  guardarToken(token: string): void {
    this._token = token;
    this._isLogged = true;
    sessionStorage.setItem('token', token);
  }

  logout(): void {
    this._token = null;
    this._isLogged = false;
    sessionStorage.clear();
    this.router.navigate(['/login']);
  }

  agregarAuthorization(httpOptions: HttpHeaders) {
    if (this._token != null) {
      return httpOptions.append('Authorization', 'Bearer ' + this._token);
    }
    return httpOptions;
  }

  hasRolAdmin(role: string): boolean {
    return true;
  }
}
