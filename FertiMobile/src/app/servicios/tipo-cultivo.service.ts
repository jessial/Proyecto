import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TipoCultivo } from './../dominio/tipo-cultivo';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TipoCultivoService {

  private tipoCultivoURL = 'http://localhost:8080/servicio_tipo_cultivo';

  constructor(private http: HttpClient) { }

  /** GET tipoCultivo from the server */
  public geBackTiposCultivo(): Observable<TipoCultivo[]> {
    const url = `${this.tipoCultivoURL}/consultaTipoCultivo`;
    return this.http.get<TipoCultivo[]>(url);
  }
}
