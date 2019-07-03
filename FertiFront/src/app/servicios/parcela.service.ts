import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Filtro } from '../clases_dominio/filtro';
import { ParcelaPaginado } from '../clases_dominio/parcela-paginado';
import { SeguridadService } from '../seguridad/servicios/seguridad.service';
import { UtilidadService } from './utilidad.service';

@Injectable({
  providedIn: 'root'
})
export class ParcelaService {
  private parcelaUrl = `${environment.URL_BASE}/servicio_parcela`;  // URL to web api

  constructor(private http: HttpClient, private utilidad: UtilidadService, private seguridadService: SeguridadService) { }


  /** GET Parcela from the server paginado*/
  private getBackParcelaPaginado(filtro: Filtro): Observable<ParcelaPaginado> {
    const pagina = filtro.pagina - 1;
    const url = `${this.parcelaUrl}/consultaTodosPaginado/${pagina}`;
    return this.http.get<ParcelaPaginado>(url).pipe(catchError(this.handleError('', null)));
  }

  private getBackParcelaConFiltroUsuario(filtro: Filtro): Observable<ParcelaPaginado> {
    const pagina = filtro.pagina - 1;
    const url = `${this.parcelaUrl}/consultaTodosFiltroUsuario/${filtro.valor}/${pagina}`;
    return this.http.get<ParcelaPaginado>(url).pipe(catchError(this.handleError('', null)));
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      this.utilidad.mensajeError('Error en la respuesta del servicio');
      return of(result as T);
    };
  }

  public getBackParcela(filtro: Filtro): Observable<ParcelaPaginado> {
    switch (filtro.numeroFiltro) {
      case 0: {
        return this.getBackParcelaPaginado(filtro);
      }
      case 1: {
        return this.getBackParcelaConFiltroUsuario(filtro);
      }
    }
  }
}
