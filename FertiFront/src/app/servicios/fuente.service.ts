import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { TipoCultivo } from '../clases_dominio/tipo-cultivo';
import { UtilidadService } from './utilidad.service';
import { catchError } from 'rxjs/operators';
import { Fuente } from '../clases_dominio/fuente';
import { HttpHeaders, HttpClient } from '@angular/common/http';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class FuenteService {

  private fuenteUrl = 'https://fetiweb.herokuapp.com/servicio_fuente';  // URL to web api
  private tipoSubject = new BehaviorSubject([]);
  private editSubject = new BehaviorSubject(new Fuente());
  private fuentes: Fuente[];

  constructor(private http: HttpClient, private utilidad: UtilidadService) { }

  /** GET Fuentes from the server */
  private getBackFuente(): Observable<Fuente[]> {
    const url = `${this.fuenteUrl}/consultaTodos`;
    return this.http.get<Fuente[]>(url).pipe(catchError(this.handleError('', [])));
  }

  /** UPDATE Fuente from the server */
  public updateOrCreate(fuente: Fuente): Observable<Fuente> {
    const url = `${this.fuenteUrl}/guardado`;
    return this.http.post<TipoCultivo>(url, fuente, httpOptions).pipe(catchError(this.handleError('', null)));
  }

  /**DELETE Fuente from de server */
  public deleteFuente(fuente: Fuente): void {
    const url = `${this.fuenteUrl}/borrarFuente/${fuente.codigoFuente}`;
    this.http.delete(url).subscribe(_ => this.cargarDatos());
  }

  crearNuevo(fuente: Fuente) {
    this.fuentes = [...this.fuentes, fuente];
    this.refresh();
  }

  cargarDatos() {
    this.getBackFuente()
      .subscribe(result => {
        this.fuentes = result;
        this.refresh();
      }
      );
  }

  getFuentes(): Observable<Fuente[]> {
    return this.tipoSubject.asObservable();
  }

  private refresh() {
    this.tipoSubject.next(this.fuentes);
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      this.utilidad.mensajeError('Error en la respuesta del servicio');
      return of(result as T);
    };
  }

  editarFuente(fuente: Fuente) {
    this.editSubject.next(fuente);
  }

  getFuente(): Observable<Fuente> {
    return this.editSubject.asObservable();
  }
}
