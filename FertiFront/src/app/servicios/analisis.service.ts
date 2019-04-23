import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { UtilidadService } from './utilidad.service';
import { Analisis } from '../clases_dominio/analisis';
import { catchError } from 'rxjs/operators';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AnalisisService {
  private analisisUrl = 'http://localhost:8080/servicio_analisis';  // URL to web api
  private analisis: Analisis[];
  private tipoSubject = new BehaviorSubject([]);
  constructor(private http: HttpClient, private utilidad: UtilidadService) { }

  /** GET Analisis from the server */
  public getBackAnalisis(): Observable<Analisis[]> {
    const url = `${this.analisisUrl}/consultaTodos`;
    return this.http.get<Analisis[]>(url).pipe(catchError(this.handleError('', [])));
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      this.utilidad.mensajeError('Error en la respuesta del servicio');
      return of(result as T);
    };
  }

  cargarDatos() {
    this.getBackAnalisis()
      .subscribe(result => {
        this.analisis = result;
        this.refresh();
      }
      );
  }
  private refresh() {
    this.tipoSubject.next(this.analisis);
  }

  getAnalisis(): Observable<Analisis[]> {
    return this.tipoSubject.asObservable();
  }
}
