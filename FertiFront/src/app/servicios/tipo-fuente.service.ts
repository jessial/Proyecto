import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '../../../node_modules/@angular/common/http';
import { UtilidadService } from './utilidad.service';
import { TipoFuente } from '../clases_dominio/tipo-fuente';
import { Observable, of, BehaviorSubject } from '../../../node_modules/rxjs';
import { catchError } from '../../../node_modules/rxjs/operators';
import { SeguridadService } from '../seguridad/servicios/seguridad.service'

@Injectable({
  providedIn: 'root'
})
export class TipoFuenteService {

  private tipoFuenteUrl = 'https://fertiweb.herokuapp.com/servicio_tipoFuente';  // URL to web api
  private tipoSubject = new BehaviorSubject([]);
  private editSubject = new BehaviorSubject(new TipoFuente());
  private tiposFuente: TipoFuente[];

  constructor(private http: HttpClient, private utilidad: UtilidadService, private seguridadService: SeguridadService) { }

  /** GET TiposDeFuente from the server */
  public getBackTipoFuente(): Observable<TipoFuente[]> {
    const url = `${this.tipoFuenteUrl}/consultaTodos`;
    return this.http.get<TipoFuente[]>(url).pipe(catchError(this.handleError('', [])));
  }

  /** UPDATE TipoFuente from the server */
  public updateOrCreate(tipoFuente: TipoFuente): Observable<TipoFuente> {
    const url = `${this.tipoFuenteUrl}/guardado`;
    return this.http.put<TipoFuente>(url, tipoFuente).pipe(catchError(this.handleError('', null)));
  }

  /**DELETE TipoFuente from the server */
  public deleteTipoFuente(tipoFuente: TipoFuente): void {
    const url = `${this.tipoFuenteUrl}/borrarTipoFuente/${tipoFuente.codigo}`;
    this.http.delete(url).subscribe(_ => this.cargarDatos());
  }

  crearNuevo(tipoFuente: TipoFuente) {
    this.tiposFuente = [...this.tiposFuente, tipoFuente];
    this.refresh();
  }

  cargarDatos() {
    this.getBackTipoFuente()
      .subscribe(result => {
        this.tiposFuente = result;
        this.refresh();
      }
      );
  }
  private refresh() {
    this.tipoSubject.next(this.tiposFuente);
  }

  getTiposFuente(): Observable<TipoFuente[]> {
    return this.tipoSubject.asObservable();
  }


  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      this.utilidad.mensajeError('Error en la respuesta del servicio');
      return of(result as T);
    };
  }

  editarTipoFuente(tipoFuente: TipoFuente) {
    this.editSubject.next(tipoFuente);
  }

  getTipoFuente(): Observable<TipoFuente> {
    return this.editSubject.asObservable();
  }

}
