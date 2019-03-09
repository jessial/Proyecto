import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { Elemento } from '../clases_dominio/elemento';
import { UtilidadService } from './utilidad.service';
import { catchError } from 'rxjs/operators';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ElementoService {

  private elementoUrl = 'http://localhost:8080/servicio_elemento';  // URL to web api
  private tipoSubject = new BehaviorSubject([]);
  private editSubject = new BehaviorSubject(new Elemento());
  private elementos: Elemento[];

  constructor(private http: HttpClient, private utilidad: UtilidadService) { }

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
