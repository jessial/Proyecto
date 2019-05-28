import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { RequerimientoCultivo } from '../clases_dominio/requerimiento-cultivo';
import { RequerimientoPorCultivo } from '../clases_dominio/requerimiento-por-cultivo';
import { SeguridadService } from '../seguridad/servicios/seguridad.service';
import { UtilidadService } from './utilidad.service';

@Injectable({
  providedIn: 'root'
})
export class RequerimientoCultivoService {

  private requerimientoUrl = 'https://fertiweb.herokuapp.com/servicio_requerimiento';  // URL to web api
  private httpOptions = new HttpHeaders({ 'Content-Type': 'application/json' });
  private tipoSubject = new BehaviorSubject([]);
  private editSubject = new BehaviorSubject(new RequerimientoCultivo());
  private requerimientosPorCultivo: RequerimientoPorCultivo[];
  private requerimientoCultivo: RequerimientoCultivo[];

  constructor(private http: HttpClient, private utilidad: UtilidadService, private seguridadService: SeguridadService) { }

  /** GET RequerimientosPorCutivo from the server */
  public getBackRequerimientosPorCultivo(): Observable<RequerimientoPorCultivo[]> {
    const url = `${this.requerimientoUrl}/consultaTodos`;
    return this.http.get<RequerimientoPorCultivo[]>(url).pipe(catchError(this.handleError('', [])));
  }

  /** UPDATE RequerimientosCutivo from the server */
  public updateOrCreate(requerimientoCultivo: RequerimientoCultivo): Observable<RequerimientoCultivo> {
    const url = `${this.requerimientoUrl}/guardado`;
    return this.http.post<RequerimientoCultivo>(url, requerimientoCultivo).pipe(catchError(this.handleError('', null)));
  }

  /**DELETE RequerimientoCultivo from the server */
  public deleteRequerimientoCultivo(requerimientoCultivo: RequerimientoCultivo): void {
    const url = `${this.requerimientoUrl}/borrarRequerimiento/${requerimientoCultivo.codigoRequerimiento}`;
    this.http.delete(url).subscribe(_ => this.cargarDatos());
  }

  cargarDatos() {
    this.getBackRequerimientosPorCultivo()
      .subscribe(result => {
        this.requerimientosPorCultivo = result;
        this.refresh();
      }
      );
  }

  private refresh() {
    this.tipoSubject.next(this.requerimientosPorCultivo);
  }

  crearNuevo(requerimiento: RequerimientoCultivo) {
    this.requerimientoCultivo = [...this.requerimientoCultivo, requerimiento];
    this.refresh();
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      this.utilidad.mensajeError('Error en la respuesta del servicio');
      return of(result as T);
    };
  }

  getRequerimientosPorCultivo(): Observable<RequerimientoPorCultivo[]> {
    return this.tipoSubject.asObservable();
  }

  editarRequerimiento(requerimiento: RequerimientoCultivo) {
    this.editSubject.next(requerimiento);
  }

  getRequerimiento(): Observable<RequerimientoCultivo> {
    return this.editSubject.asObservable();
  }
}
