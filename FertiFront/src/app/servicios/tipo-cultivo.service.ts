import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { TipoCultivo } from '../calses_dominio/tipo-cultivo';
import { catchError, map, tap } from 'rxjs/operators';
import { UtilidadService } from './utilidad.service';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class TipoCultivoService {

  private tipoCultivoUrl = 'http://localhost:8080/servicio_tipo_cultivo';  // URL to web api
  private tipoSubject = new BehaviorSubject([]);
  private editSubject = new BehaviorSubject(new TipoCultivo());
  private tiposCultivo: TipoCultivo[];

  constructor(private http: HttpClient, private utilidad: UtilidadService) { }

  /** GET TiposCutivo from the server */
  private getBackTiposCultivo(): Observable<TipoCultivo[]> {
    const url = `${this.tipoCultivoUrl}/consultaTodos`;
    return this.http.get<TipoCultivo[]>(url).pipe(catchError(this.handleError('', [])));
  }

  /** UPDATE TiposCutivo from the server */
  public updateOrCreate(tipoCultivo: TipoCultivo): Observable<TipoCultivo> {
    const url = `${this.tipoCultivoUrl}/actualizaRegistro`;
    return this.http.put<TipoCultivo>(url, tipoCultivo, httpOptions).pipe(catchError(this.handleError('', null)));
  }

  /**DELETE TipoCultivo from de server */
  public deleteTipoCultivo(tipoCultivo: TipoCultivo): void {
    const url = `${this.tipoCultivoUrl}/borrarCultivo/${tipoCultivo.codigoCultivoSembrado}`;
    console.log(url);
    this.http.delete(url).subscribe();
  }

  crearNuevo(tipoCultivo: TipoCultivo) {
    this.tiposCultivo = [...this.tiposCultivo, tipoCultivo];
    this.refresh();
  }

  cargarDatos() {
    this.getBackTiposCultivo()
      .subscribe(result => {
        this.tiposCultivo = result;
        this.refresh();
      }
      );
  }

  getTiposCultivo(): Observable<TipoCultivo[]> {
    return this.tipoSubject.asObservable();
  }

  private refresh() {
    this.tipoSubject.next(this.tiposCultivo);
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      this.utilidad.mensajeError('Error en la respuesta del servicio');
      return of(result as T);
    };
  }

  editarCultivo(tipoCultivo: TipoCultivo) {
    this.editSubject.next(tipoCultivo);
  }

  getCultivo(): Observable<TipoCultivo> {
    return this.editSubject.asObservable();
  }
}
