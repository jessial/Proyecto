import { Injectable } from '@angular/core';
import { Unidad } from '../clases_dominio/unidad';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { UtilidadService } from './utilidad.service';
import { catchError } from 'rxjs/operators';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { SeguridadService } from '../seguridad/servicios/seguridad.service'

@Injectable({
  providedIn: 'root'
})
export class UnidadService {

  private unidadUrl = 'https://fertiweb.herokuapp.com/servicio_tipoFuente';  // URL to web api
  private tipoSubject = new BehaviorSubject([]);
  private editSubject = new BehaviorSubject(new Unidad());
  private tiposFuente: Unidad[];

  constructor(private http: HttpClient, private utilidad: UtilidadService, private seguridadService: SeguridadService) { }

  /** GET Unidad from the server */
  public getBackUnidad(): Observable<Unidad[]> {
    const url = `${this.unidadUrl}/consultaUnidad`;
    return this.http.get<Unidad[]>(url).pipe(catchError(this.handleError('', [])));
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      this.utilidad.mensajeError('Error en la respuesta del servicio');
      return of(result as T);
    };
  }
}
