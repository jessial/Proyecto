import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { TipoCultivo } from '../calses_dominio/tipo-cultivo';
import { catchError, map, tap } from 'rxjs/operators';
import { UtilidadService } from './utilidad.service';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class TipoCultivoService {

  private tipoCultivoUrl = 'http://localhost:8080/servicio_tipo_cultivo';  // URL to web api

  constructor(private http: HttpClient, private utilidad: UtilidadService) { }

  /** GET TiposCutivo from the server */
  public getTiposCultivo(): Observable<TipoCultivo[]> {
    const url = `${this.tipoCultivoUrl}/consultaTodos`;
    return this.http.get<TipoCultivo[]>(url).pipe(catchError(this.handleError('',[])));
  }

  /** UPDATE TiposCutivo from the server */
  public updateTiposCultivo(tipoCultivo: TipoCultivo): Observable<TipoCultivo> {
    const url = `${this.tipoCultivoUrl}/actualizaRegistro`;
    return this.http.put<TipoCultivo>(url, tipoCultivo, httpOptions).pipe(catchError(this.handleError('', null)));
  }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      this.utilidad.mensajeError("Error en la respuesta del servicio");
      return of(result as T);
    };
  }
}
