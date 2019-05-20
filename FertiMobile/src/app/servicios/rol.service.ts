import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Rol } from '../dominio/rol';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RolService {

  private rolURL = 'http://localhost:8080/servicio_rol';  // URL to web api
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
