import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UsuarioSeguridad } from '../../clases_dominio/usuarioSeguridad';
import { Observable, of, throwError } from 'rxjs';
import { Router } from '@angular/router';
import { catchError } from 'rxjs/operators';
import { LocalService } from 'src/app/servicios/local.service';

const credenciales = btoa('FertiFront'+':'+'fertipass');
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded',
  'Authorization': 'Basic ' + credenciales})
};

@Injectable({
  providedIn: 'root'
})
export class SeguridadService {

  private loginUrl = 'http://localhost:8080/oauth/token';  // URL to web api
  private router: Router;
  private _isLogged : boolean = false;
  private _token: string;

  constructor(private http: HttpClient, private servicioLocal: LocalService) { }

  public getAuth(usuario: UsuarioSeguridad): any {
    let params = new URLSearchParams();
    params.set('grant_type', 'password');
    params.set('username', usuario.nombreUsuario);
    params.set('password', usuario.password);
    return this.http.post<Observable<any>>(this.loginUrl, params.toString(), httpOptions);
  }

  isAuthenticated(): boolean{
    return this._isLogged;
  }

  obtenerDatosToken(token: string):any{
    if(token != null){
      return JSON.parse(atob(token.split(".")[1]));
    }
    return null;
  }

  guardarToken(token: string): void{
    this._token = token;
    this._isLogged = true;
    sessionStorage.setItem('token', token);
  }

  logout(): void{
    this._token = null;
    this._isLogged = false;
    sessionStorage.clear();
    this.router.navigate(['/login']);
  }

  agregarAuthorization(httpOptions: HttpHeaders){
    if(this._token != null){
      return httpOptions.append('Authorization', 'Bearer ' + this._token);
    }
    return httpOptions;
  }

  hasRolAdmin(role: string): boolean{
    return true;
  }
}
