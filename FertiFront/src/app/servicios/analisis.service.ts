import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { AnalisisPaginado } from '../clases_dominio/analisis-paginado';
import { Filtro } from '../clases_dominio/filtro';
import { SeguridadService } from '../seguridad/servicios/seguridad.service'
import { environment } from 'src/environments/environment';
import { UtilidadService } from './utilidad.service';

@Injectable({
  providedIn: 'root'
})
export class AnalisisService {
  private analisisUrl = `${environment.URL_BASE}/servicio_analisis`;  // URL to web api

  constructor(private http: HttpClient, private utilidad: UtilidadService, private seguridadService: SeguridadService) { }

  /** GET Analisis from the server */
  private getBackAnalisisPaginado(filtro: Filtro): Observable<AnalisisPaginado> {
    const pagina = filtro.pagina - 1;
    const url = `${this.analisisUrl}/consultaTodosPaginado/${pagina}`;
    return this.http.get<AnalisisPaginado>(url).pipe(catchError(this.handleError('', null)));
  }

  private getBackAnalisisFiltro1(filtro: Filtro): Observable<AnalisisPaginado> {
    const pagina = filtro.pagina - 1;
    const url = `${this.analisisUrl}/consultaTodosFiltro1/${filtro.valor}/${pagina}`;
    return this.http.get<AnalisisPaginado>(url).pipe(catchError(this.handleError('', null)));
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      this.utilidad.mensajeError('Error en la respuesta del servicio');
      return of(result as T);
    };
  }

  public getBackAnalisis(filtro: Filtro): Observable<AnalisisPaginado> {
    switch (filtro.numeroFiltro) {
      case 0: {
        return this.getBackAnalisisPaginado(filtro);
      }
      case 1: {
        return this.getBackAnalisisFiltro1(filtro);
      }
    }
  }
}
