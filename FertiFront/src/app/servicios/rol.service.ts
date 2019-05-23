import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UtilidadService } from './utilidad.service';
import { Observable, of, BehaviorSubject } from 'rxjs';
import { Rol } from '../clases_dominio/rol';
import { catchError, map, tap } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class RolService {

  private rolUrl = 'https://fetiweb.herokuapp.com/servicio_rol';  // URL to web api
  private roles: Rol[];
  private tipoSubject = new BehaviorSubject([]);
  private editSubject = new BehaviorSubject(new Rol());

  constructor(private http: HttpClient, private utilidad: UtilidadService) { }

  /** GET roles from the server */
  public geBackRoles(): Observable<Rol[]> {
    const url = `${this.rolUrl}/consultaTodos`;
    return this.http.get<Rol[]>(url).pipe(catchError(this.handleError('', [])));
  }

  /** UPDATE roles from the server */
  public updateOrCreate(rol: Rol): Observable<Rol> {
    const url = `${this.rolUrl}/actualizaRegistro`;
    return this.http.put<Rol>(url, rol, httpOptions).pipe(catchError(this.handleError('', null)));
  }

  /**DELETE ROLES from the server */
  public deleteRoles(rol: Rol): void {
    const url = `${this.rolUrl}/borrarRol/${rol.codigo}`;
    this.http.delete(url).subscribe(_ => this.cargarDatos());
  }

  crearNuevo(rol: Rol) {
    this.roles = [...this.roles, rol];
    this.refresh();
  }

  cargarDatos() {
    this.geBackRoles()
      .subscribe(result => {
        this.roles = result;
        this.refresh();
      }
      );
  }

  getRoles(): Observable<Rol[]> {
    return this.tipoSubject.asObservable();
  }

  private refresh() {
    this.tipoSubject.next(this.roles);
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      this.utilidad.mensajeError('Error en la respuesta del servicio');
      return of(result as T);
    };
  }

  editarRoles(rol: Rol) {
    this.editSubject.next(rol);
  }

  getRol(): Observable<Rol> {
    return this.editSubject.asObservable();
  }
}
