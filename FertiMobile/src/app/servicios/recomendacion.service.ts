import { Observable } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { SeguridadService } from './seguridad.service';
import { DTORecomendacion } from '../dto/dto-recomendacion';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class RecomendacionService {

  private recomendacionURL = `${environment.URL_BASE}/servicio_recomendacion`;  // URL to web api

  private recomendaciones: DTORecomendacion[];

  constructor(private http: HttpClient, private seguridadService: SeguridadService) { }

  /** GET parcelas from the server */
  public geBackParcelas(): Observable<DTORecomendacion[]> {
    const url = `${this.recomendacionURL}/consultaPorAnalisis/${this.seguridadService.obtenerDocumentoUsuario()}`;
    return this.http.get<DTORecomendacion[]>(url);
  }

}
