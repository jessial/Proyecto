import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { UtilidadService } from './utilidad.service';
import { AnalisisPaginado } from '../clases_dominio/analisis-paginado';
import { catchError } from 'rxjs/operators';
import { Filtro } from '../clases_dominio/filtro';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AnalisisService {
  private analisisUrl = 'https://fetiweb.herokuapp.com/servicio_analisis';  // URL to web api
  constructor(private http: HttpClient, private utilidad: UtilidadService) { }

  /** GET Analisis from the server */
  private getBackAnalisisPaginado(filtro: Filtro): Observable<AnalisisPaginado> {
    let pagina = filtro.pagina - 1;
    const url = `${this.analisisUrl}/consultaTodosPaginado/${pagina}`;
    return this.http.get<AnalisisPaginado>(url).pipe(catchError(this.handleError('', null)));
  }

  private getBackAnalisisFiltro1(filtro: Filtro): Observable<AnalisisPaginado> {
    let pagina = filtro.pagina - 1;
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
    switch(filtro.numeroFiltro) { 
      case 0: { 
         return this.getBackAnalisisPaginado(filtro);
      } 
      case 1: { 
        return this.getBackAnalisisFiltro1(filtro);
      } 
   } 
  }
}
