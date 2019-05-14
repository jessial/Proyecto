import { Unidad } from './../dominio/unidad';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UnidadService {

  private unidadUrl = 'http://localhost:8080/servicio_tipoFuente';  // URL to web api

  constructor(private http: HttpClient) { }

  /** GET Unidad from the server */
  public getBackUnidad(): Observable<Unidad[]> {
    const url = `${this.unidadUrl}/consultaUnidad`;
    return this.http.get<Unidad[]>(url);
  }
}
