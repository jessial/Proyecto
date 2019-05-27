import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { TipoCultivo } from '../clases_dominio/tipo-cultivo';
import { SeguridadService } from '../seguridad/servicios/seguridad.service';
import { UtilidadService } from './utilidad.service';

@Injectable({
  providedIn: 'root'
})
export class TipoCultivoService {

  private tipoCultivoUrl = 'http://localhost:8080/servicio_tipo_cultivo';  // URL to web api
  private tipoSubject = new BehaviorSubject([]);
  private editSubject = new BehaviorSubject(new TipoCultivo());
  private tiposCultivo: TipoCultivo[];

  constructor(private http: HttpClient, private utilidad: UtilidadService, private seguridadService: SeguridadService) { }

  /** GET TiposCutivo from the server */
  public getBackTiposCultivo(): Observable<TipoCultivo[]> {
    const url = `${this.tipoCultivoUrl}/consultaTodos`;
    return this.http.get<TipoCultivo[]>(url).pipe(catchError(this.handleError('', [])));
  }

  /** UPDATE TiposCutivo from the server */
  public updateOrCreate(tipoCultivo: TipoCultivo): Observable<TipoCultivo> {
    const url = `${this.tipoCultivoUrl}/actualizaRegistro`;
    return this.http.put<TipoCultivo>(url, tipoCultivo).pipe(catchError(this.handleError('', null)));
  }

  /**DELETE TipoCultivo from de server */
  public deleteTipoCultivo(tipoCultivo: TipoCultivo): void {
    const url = `${this.tipoCultivoUrl}/borrarTipoCultivo/${tipoCultivo.codigoTipoCultivo}`;
    this.http.delete(url).subscribe(_ => this.cargarDatos(), error => this.utilidad.mensajeErrorEliminar(error.error.message));
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
