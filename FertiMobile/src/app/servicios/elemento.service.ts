import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { Elemento } from '../dominio/elemento';

@Injectable({
  providedIn: 'root'
})
export class ElementoService {

  private elementoUrl = `${environment.URL_BASE}/servicio_elemento`;  // URL to web api

  constructor(private http: HttpClient) { }

  /** GET Elemento from the server */
  public getBackElementos(): Observable<Elemento[]> {
    const url = `${this.elementoUrl}/consultaElemento`;
    return this.http.get<Elemento[]>(url);
  }
}
