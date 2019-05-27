import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Fuente } from '../clases_dominio/fuente';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { UtilidadService } from './utilidad.service';
import { catchError } from 'rxjs/operators';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class FuenteService {

  private fuenteUrl = 'https://fertiweb.herokuapp.com/servicio_fuente';  // URL to web api
  private fuentes: Fuente[];
  private fuente: Fuente[];
  private tipoSubject = new BehaviorSubject([]);
  private editSubject = new BehaviorSubject(new Fuente());

  constructor(private http: HttpClient, private utilidad: UtilidadService) { }

  /** GET fuentes from the server */
  public geBackFuentes(): Observable<Fuente[]> {
    const url = `${this.fuenteUrl}/consultaTodos`;
    return this.http.get<Fuente[]>(url).pipe(catchError(this.handleError('', [])));
  }

  /** UPDATE RequerimientosCutivo from the server */
  public updateOrCreate(fuente: Fuente): Observable<Fuente> {
    const url = `${this.fuenteUrl}/guardado`;
    return this.http.post<Fuente>(url, fuente, httpOptions).pipe(catchError(this.handleError('', null)));
  }

  /**DELETE RequerimientoCultivo from the server */
  public deleteFuente(fuente: Fuente): void {
    const url = `${this.fuenteUrl}/borrarFuente/${fuente.codigoFuente}`;
    this.http.delete(url).subscribe(_ => this.cargarDatos());
  }

  cargarDatos() {
    this.geBackFuentes()
      .subscribe(result => {
        this.fuentes = result;
        this.refresh();
      }
      );
  }

  private refresh() {
    this.tipoSubject.next(this.fuentes);
  }

  crearNuevo(fuente: Fuente) {
    this.fuente = [...this.fuente, fuente];
    this.refresh();
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      this.utilidad.mensajeError('Error en la respuesta del servicio');
      return of(result as T);
    };
  }

  getFuentes(): Observable<Fuente[]> {
    return this.tipoSubject.asObservable();
  }

  editarFuente(fuente: Fuente) {
    this.editSubject.next(fuente);
  }

  getFuente(): Observable<Fuente> {
    return this.editSubject.asObservable();
  }

}
