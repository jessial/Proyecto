import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { Rol } from '../dominio/rol';

@Injectable({
  providedIn: 'root'
})
export class RolService {

  private rolURL = `${environment.URL_BASE}/servicio_rol`;  // URL to web api

  private roles: Rol[];
  private rolSubject = new BehaviorSubject([]);

  constructor(private http: HttpClient) { }

  /** GET roles from the server */
  public geBackRoles(): Observable<Rol[]> {
    const url = `${this.rolURL}/consultaRoles`;
    return this.http.get<Rol[]>(url);
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
    return this.rolSubject.asObservable();
  }

  private refresh() {
    this.rolSubject.next(this.roles);
  }
}
