import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { Injectable } from '@angular/core';
import { Fuente } from '../dominio/fuente';

@Injectable({
  providedIn: 'root'
})
export class FuenteService {

  private fuenteURL = 'http://localhost:8080/servicio_fuente';  // URL to web api
  private fuentesNitrogeno: Fuente[];
  private fuentesNitrogenoSubject = new BehaviorSubject([]);
  private fuentesPotasio: Fuente[];
  private fuentesPotasioSubject = new BehaviorSubject([]);
  private fuentesFosforo: Fuente[];
  private fuentesFosforoSubject = new BehaviorSubject([]);

  constructor(private http: HttpClient) { }

  /** GET fuentes nitróngeno from the server */
  public geBackFuentesNitrogeno(): Observable<Fuente[]> {
    const url = `${this.fuenteURL}/consultaNitrogeno`;
    return this.http.get<Fuente[]>(url);
  }

  cargarDatosFuenteNitrogeno() {
    this.geBackFuentesNitrogeno()
      .subscribe(result => {
        this.fuentesNitrogeno = result;
        this.refreshFuentesNitrogeno();
      });
  }

  getFuentesNitrogeno(): Observable<Fuente[]> {
    return this.fuentesNitrogenoSubject.asObservable();
  }

  private refreshFuentesNitrogeno() {
    this.fuentesNitrogenoSubject.next(this.fuentesNitrogeno);
  }

  /** GET fuentes potasio from the server */
  public geBackFuentesPotasio(): Observable<Fuente[]> {
    const url = `${this.fuenteURL}/consultaPotasio`;
    return this.http.get<Fuente[]>(url);
  }

  cargarDatosFuentePotasio() {
    this.geBackFuentesPotasio()
      .subscribe(result => {
        this.fuentesPotasio = result;
        this.refreshFuentesPotasio();
      });
  }

  getFuentesPotasio(): Observable<Fuente[]> {
    return this.fuentesPotasioSubject.asObservable();
  }

  private refreshFuentesPotasio() {
    this.fuentesPotasioSubject.next(this.fuentesPotasio);
  }

  /** GET fuentes fosforo from the server */
  public geBackFuentesFosforo(): Observable<Fuente[]> {
    const url = `${this.fuenteURL}/consultaFosforo`;
    return this.http.get<Fuente[]>(url);
  }

  cargarDatosFuenteFosforo() {
    this.geBackFuentesFosforo()
      .subscribe(result => {
        this.fuentesFosforo = result;
        this.refreshFuentesFosforo();
      });
  }

  getFuentesFosforo(): Observable<Fuente[]> {
    return this.fuentesFosforoSubject.asObservable();
  }

  private refreshFuentesFosforo() {
    this.fuentesFosforoSubject.next(this.fuentesFosforo);
  }

}
