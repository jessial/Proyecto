import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Parcela } from '../clases_dominio/parcela';
import { SeguridadService } from '../seguridad/servicios/seguridad.service';
import { UtilidadService } from './utilidad.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ParcelaService {
  private parcelaUrl = `${environment.URL_BASE}/servicio_parcela`;  // URL to web api
  private parcelas: Parcela[];
  private tipoSubject = new BehaviorSubject([]);
  constructor(private http: HttpClient, private utilidad: UtilidadService, private seguridadService: SeguridadService) { }


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
