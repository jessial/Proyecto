import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { Unidad } from './../dominio/unidad';

@Injectable({
  providedIn: 'root'
})
export class UnidadService {

  private unidadUrl = `${environment.URL_BASE}/servicio_tipoFuente`;  // URL to web api

  constructor(private http: HttpClient) { }

  /** GET Unidad from the server */
  public getBackUnidad(): Observable<Unidad[]> {
    const url = `${this.unidadUrl}/consultaUnidad`;
    return this.http.get<Unidad[]>(url);
  }
}
