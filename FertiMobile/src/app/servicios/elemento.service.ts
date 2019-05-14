import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Elemento } from '../dominio/elemento';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ElementoService {

  private elementoUrl = 'http://localhost:8080/servicio_elemento';  // URL to web api

  constructor(private http: HttpClient) { }

  /** GET Elemento from the server */
  public getBackElementos(): Observable<Elemento[]> {
    const url = `${this.elementoUrl}/consultaElemento`;
    return this.http.get<Elemento[]>(url);
  }
}
