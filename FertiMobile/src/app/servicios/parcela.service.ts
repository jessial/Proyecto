import { SeguridadService } from './seguridad.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { Parcela } from '../dominio/parcela';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ParcelaService {

  private parcelaURL = `${environment.URL_BASE}/servicio_parcela`;  // URL to web api

  private parcelas: Parcela[];
  private parcelaSubject = new BehaviorSubject([]);
  private editSubject = new BehaviorSubject(new Parcela());

  constructor(private http: HttpClient, private seguridadService: SeguridadService) { }

  /** GET parcelas from the server */
  public geBackParcelas(): Observable<Parcela[]> {
    const url = `${this.parcelaURL}/consultaParcela/${this.seguridadService.obtenerDocumentoUsuario()}`;
    return this.http.get<Parcela[]>(url);
  }

  /** UPDATE parcela from the server */
  public updateOrCreate(parcela: Parcela): Observable<Parcela> {
    const url = `${this.parcelaURL}/actualizaRegistro`;
    return this.http.put<Parcela>(url, parcela, httpOptions);
  }

  /**DELETE parcela from the server */
  public deleteParcela(parcela: Parcela): void {
    const url = `${this.parcelaURL}/borrarParcela/${parcela.codigoParcela}`;
    this.http.delete(url).subscribe(_ => this.cargarDatos());
  }

  crearNuevo(parcela: Parcela) {
    this.parcelas = [...this.parcelas, parcela];
    this.refresh();
  }

  cargarDatos() {
    this.geBackParcelas()
      .subscribe(result => {
        this.parcelas = result;
        this.refresh();
      }
      );
  }

  getParcelas(): Observable<Parcela[]> {
    return this.parcelaSubject.asObservable();
  }

  private refresh() {
    this.parcelaSubject.next(this.parcelas);
  }

  editarParcela(parcela: Parcela) {
    this.editSubject.next(parcela);
  }

  getParcela(): Observable<Parcela> {
    return this.editSubject.asObservable();
  }
}
