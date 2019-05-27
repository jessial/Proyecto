import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { TipoCultivo } from './../dominio/tipo-cultivo';

@Injectable({
  providedIn: 'root'
})
export class TipoCultivoService {

  private tipoCultivoURL = `${environment.URL_BASE}/servicio_tipo_cultivo`;  // URL to web api

  constructor(private http: HttpClient) { }

  /** GET tipoCultivo from the server */
  public geBackTiposCultivo(): Observable<TipoCultivo[]> {
    const url = `${this.tipoCultivoURL}/consultaTipoCultivo`;
    return this.http.get<TipoCultivo[]>(url);
  }
}
