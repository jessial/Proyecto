import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Usuario } from './../dominio/usuario';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class RegistroUsuarioService {

  private usuarioUrl = `${environment.URL_BASE}/servicio_usuario`;

  constructor(private http: HttpClient) { }

  /** UPDATE usuario from the server */
  public updateOrCreate(usuario: Usuario): Observable<Usuario> {
    const url = `${this.usuarioUrl}/guardadoUsuario`;
    return this.http.post<Usuario>(url, usuario, httpOptions);
  }

}
