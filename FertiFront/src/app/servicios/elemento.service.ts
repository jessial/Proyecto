import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Elemento } from '../clases_dominio/elemento';
import { UtilidadService } from './utilidad.service';
import { catchError } from 'rxjs/operators';
import { SeguridadService } from '../seguridad/servicios/seguridad.service'

@Injectable({
  providedIn: 'root'
})
export class ElementoService {

  private elementoUrl = 'https://fertiweb.herokuapp.com/servicio_elemento';  // URL to web app

  constructor(private http: HttpClient, private utilidad: UtilidadService, private seguridadService: SeguridadService) { }

  /** GET Elemento from the server */
  public getBackElementos(): Observable<Elemento[]> {
    const url = `${this.elementoUrl}/consultaElemento`;
    return this.http.get<Elemento[]>(url).pipe(catchError(this.handleError('', [])));
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      this.utilidad.mensajeError('Error en la respuesta del servicio');
      return of(result as T);
    };
  }
}
