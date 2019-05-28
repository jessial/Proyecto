import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Unidad } from '../clases_dominio/unidad';
import { SeguridadService } from '../seguridad/servicios/seguridad.service';
import { UtilidadService } from './utilidad.service';

@Injectable({
  providedIn: 'root'
})
export class UnidadService {

  private unidadUrl = `${environment.URL_BASE}/servicio_tipoFuente`;  // URL to web api
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
