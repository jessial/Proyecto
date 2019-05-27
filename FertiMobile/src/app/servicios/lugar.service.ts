import { environment } from 'src/environments/environment.prod';
import { Lugar } from './../dominio/lugar';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class LugarService {

  private lugarURL = `${environment.URL_BASE}/servicio_lugar`;  // URL to web api

  private lugares: Lugar[];
  private lugarSubject = new BehaviorSubject([]);
  private editSubject = new BehaviorSubject(new Lugar());

  constructor(private http: HttpClient) { }

  /** GET lugares from the server */
  public geBackLugares(): Observable<Lugar[]> {
    const url = `${this.lugarURL}/consultaTodos`;
    return this.http.get<Lugar[]>(url);
  }

  /** UPDATE lugar from the server */
  public updateOrCreate(lugar: Lugar): Observable<Lugar> {
    const url = `${this.lugarURL}/actualizaRegistro`;
    return this.http.put<Lugar>(url, lugar, httpOptions);
  }

  /**DELETE LUGAR from the server */
  public deleteLugar(lugar: Lugar): void {
    const url = `${this.lugarURL}/borrarLugar/${lugar.codigoLugar}`;
    this.http.delete(url).subscribe(_ => this.cargarDatos());
  }

  crearNuevo(lugar: Lugar) {
    this.lugares = [...this.lugares, lugar];
    this.refresh();
  }

  cargarDatos() {
    this.geBackLugares()
      .subscribe(result => {
        this.lugares = result;
        this.refresh();
      }
      );
  }

  getLugares(): Observable<Lugar[]> {
    return this.lugarSubject.asObservable();
  }

  private refresh() {
    this.lugarSubject.next(this.lugares);
  }

  editarLugar(lugar: Lugar) {
    this.editSubject.next(lugar);
  }

  getLugar(): Observable<Lugar> {
    return this.editSubject.asObservable();
  }
}
