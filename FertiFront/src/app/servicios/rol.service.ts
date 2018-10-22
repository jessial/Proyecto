import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UtilidadService } from './utilidad.service';
import { Observable, of } from 'rxjs';
import { Rol } from '../calses_dominio/rol';
import { catchError, map, tap } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class RolService {

  private rolUrl = 'http://localhost:8080/servicio_rol';  // URL to web api

  constructor(private http: HttpClient, private utilidad: UtilidadService) { }

  /** GET TiposCutivo from the server */
  public getRoles(): Observable<Rol[]> {
    const url = `${this.rolUrl}/consultaTodos`;
    return this.http.get<Rol[]>(url).pipe(catchError(this.handleError('',[])));
  }

  /** UPDATE TiposCutivo from the server */
  public updateRoles(rol: Rol): Observable<Rol> {
    const url = `${this.rolUrl}/guardado`;
    return this.http.put<Rol>(url, rol, httpOptions).pipe(catchError(this.handleError('', null)));
  }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      this.utilidad.mensajeError("Error en la respuesta del servicio");
      return of(result as T);
    };
  }
}
