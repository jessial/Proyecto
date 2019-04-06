import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UtilidadService } from './utilidad.service';
import { Observable, of, BehaviorSubject } from 'rxjs';
import { Parcela } from '../clases_dominio/parcela';
import { catchError } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ParcelaService {
  private parcelaUrl = 'http://localhost:8080/servicio_parcela';  // URL to web api
  private parcelas: Parcela[];
  private tipoSubject = new BehaviorSubject([]);
  constructor(private http: HttpClient, private utilidad: UtilidadService) { }


  /** GET Parcela from the server */
  public getBackParcela(): Observable<Parcela[]> {
    const url = `${this.parcelaUrl}/consultaTodos`;
    return this.http.get<Parcela[]>(url).pipe(catchError(this.handleError('', [])));
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      this.utilidad.mensajeError('Error en la respuesta del servicio');
      return of(result as T);
    };
  }

  cargarDatos() {
    this.getBackParcela()
      .subscribe(result => {
        this.parcelas = result;
        this.refresh();
      }
      );
  }
  private refresh() {
    this.tipoSubject.next(this.parcelas);
  }

  getParcelas(): Observable<Parcela[]> {
    return this.tipoSubject.asObservable();
  }
}
