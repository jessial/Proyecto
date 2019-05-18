import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { DTOAnalisis } from '../dto/dto-analisis';
import { Observable, BehaviorSubject } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AnalisisService {
  private analisisUrl = 'http://localhost:8080/servicio_analisis';  // URL to web api
  private detalleAnalisis: DTOAnalisis;
  private analisis: DTOAnalisis[];
  private analisisSubject = new BehaviorSubject([]);

  constructor(private http: HttpClient) { }

  /** UPDATE lugar from the server */
  public updateOrCreate(lugar: DTOAnalisis): Observable<DTOAnalisis> {
    const url = `${this.analisisUrl}/guardadoAnalisis`;
    return this.http.post<DTOAnalisis>(url, lugar, httpOptions);
  }

  /** GET parcelas from the server */
  public geBackAnalisis(): Observable<DTOAnalisis[]> {
    const url = `${this.analisisUrl}/consultaTodos`;
    return this.http.get<DTOAnalisis[]>(url);
  }

  cargarDatos() {
    this.geBackAnalisis()
      .subscribe(result => {
        this.analisis = result;
        this.refresh();
      }
      );
  }

  private refresh() {
    this.analisisSubject.next(this.analisis);
  }

  getAnalisis(): Observable<DTOAnalisis[]> {
    return this.analisisSubject.asObservable();
  }

  public setDetalleAnalisis(analisis: DTOAnalisis) {
    this.detalleAnalisis = analisis;
  }

  public getDetalleAnalisis(): DTOAnalisis {
    return this.detalleAnalisis;
  }

}
