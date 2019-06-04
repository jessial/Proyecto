import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NavController } from '@ionic/angular';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { UsuarioSeguridad } from '../dominio/usuario-seguridad';

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

  private loginUrl = `${environment.URL_BASE}/oauth/token`;
  private _isLogged = false;
  private _token: string;

  constructor(private http: HttpClient, private navCtrl: NavController) { }

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

  guardarDocumentoUsuario(documento: any) {
    sessionStorage.setItem('documento', documento);
  }

  obtenerDocumentoUsuario(): number {
    return parseInt(sessionStorage.getItem('documento'), 10);
  }

  logout(): void {
    this._token = null;
    this._isLogged = false;
    sessionStorage.clear();
    this.navCtrl.navigateRoot('/');
  }

  agregarAuthorization(httpHeaders: HttpHeaders) {
    if (this._token != null) {
      return httpHeaders.append('Authorization', 'Bearer ' + this._token);
    }
    return httpHeaders;
  }

}
