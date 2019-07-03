import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject, BehaviorSubject } from 'rxjs';
import { environment } from 'src/environments/environment';
import { DTORecomendacion } from '../dto/dto-recomendacion';
import { FuenteParaRecomendacion } from './../dto/fuente-para-recomendacion';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class RecomendacionService {

  private recomendacionURL = `${environment.URL_BASE}/servicio_recomendacion`;  // URL to web api
  private recomendaciones: DTORecomendacion[];
  private recomendacionesSubject = new BehaviorSubject([]);

  constructor(private http: HttpClient) { }

  /** GET parcelas from the server */
  public getBackRecomendaciones(idAnalisis: number): Observable<DTORecomendacion[]> {
    const url = `${this.recomendacionURL}/consultaPorAnalisis/${idAnalisis}`;
    return this.http.get<DTORecomendacion[]>(url);
  }

  public generarRecomendacion(fuenteParaRecomendacion: FuenteParaRecomendacion): Observable<DTORecomendacion> {
    const url = `${this.recomendacionURL}/generarRecomendacion`;
    return this.http.post<DTORecomendacion>(url, fuenteParaRecomendacion, httpOptions);
  }

  cargarDatos(idAnalisis: number) {
    this.getBackRecomendaciones(idAnalisis)
      .subscribe(result => {
        this.recomendaciones = result;
        this.refresh();
      }
      );
  }

  private refresh() {
    this.recomendacionesSubject.next(this.recomendaciones);
  }

  getRecomendaciones(): Observable<DTORecomendacion[]> {
    return this.recomendacionesSubject.asObservable();
  }

}
