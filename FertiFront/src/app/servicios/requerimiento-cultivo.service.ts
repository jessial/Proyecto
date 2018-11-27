import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UtilidadService } from './utilidad.service';
import { Observable, of } from 'rxjs';
import { RequerimientoCultivo } from '../calses_dominio/requerimiento-cultivo';
import { catchError } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class RequerimientoCultivoService {

  private requerimientoUrl = 'http://localhost:8080/servicio_requerimiento';  // URL to web api

  constructor(private http: HttpClient, private utilidad: UtilidadService) { }

  /** GET RequerimientosCutivo from the server */
  public getRequerimientos(): Observable<RequerimientoCultivo[]> {
    const url = `${this.requerimientoUrl}/consultaTodos`;
    return this.http.get<RequerimientoCultivo[]>(url).pipe(catchError(this.handleError('', [])));
  }

  /** UPDATE RequerimientosCutivo from the server */
  public updateRequerimientos(requerimientoCultivo: RequerimientoCultivo): Observable<RequerimientoCultivo> {
    const url = `${this.requerimientoUrl}/guardado`;
    return this.http.post<RequerimientoCultivo>(url, requerimientoCultivo, httpOptions).pipe(catchError(this.handleError('', null)));
  }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      this.utilidad.mensajeError('Error en la respuesta del servicio');
      return of(result as T);
    };
  }
}
