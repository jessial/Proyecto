import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '../../../node_modules/@angular/common/http';
import { UtilidadService } from './utilidad.service';
import { TipoFuente } from '../calses_dominio/tipo-fuente';
import { Observable, of, BehaviorSubject } from '../../../node_modules/rxjs';
import { catchError } from '../../../node_modules/rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class TipoFuenteService {

  private tipoFuenteUrl = 'http://localhost:8080/servicio_tipoFuente';  // URL to web api
  private tipoSubject = new BehaviorSubject([]);
  private editSubject = new BehaviorSubject(new TipoFuente());
  private tiposFuente: TipoFuente[];

  constructor(private http: HttpClient, private utilidad: UtilidadService) { }

  /** GET TiposDeFuente from the server */
  public getTipoFuenteBack(): Observable<TipoFuente[]> {
    const url = `${this.tipoFuenteUrl}/consultaTodos`;
    return this.http.get<TipoFuente[]>(url).pipe(catchError(this.handleError('', [])));
  }

  /** UPDATE TipoFuente from the server */
  public updateTipoFuente(tipoFuente: TipoFuente): Observable<TipoFuente> {
    const url = `${this.tipoFuenteUrl}/guardado`;
    return this.http.put<TipoFuente>(url, tipoFuente, httpOptions).pipe(catchError(this.handleError('', null)));
  }

  crearNuevo(tipoFuente: TipoFuente) {
    this.tiposFuente = [...this.tiposFuente, tipoFuente];
    this.refresh();
  }

  cargarDatos() {
    this.getTipoFuenteBack()
      .subscribe(result => {
        this.tiposFuente = result;
        this.refresh();
      }
      );
  }
  private refresh() {
    this.tipoSubject.next(this.tiposFuente);
  }

  getTipoFuente(): Observable<TipoFuente> {
    return this.editSubject.asObservable();
  }

   /**DELETE TipoCultivo from de server */
   public deleteTipoFuente(tipoFuente: TipoFuente): void {
    const url = `${this.tipoFuenteUrl}/borrar_tipo_fuente/${tipoFuente.codigo}`;
    console.log(url);
    this.http.delete(url).subscribe();
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

}