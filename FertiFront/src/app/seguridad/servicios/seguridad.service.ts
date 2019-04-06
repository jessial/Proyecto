import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usuario } from '../../clases_dominio/usuario';
import { Observable, of, throwError } from 'rxjs';
import { Router } from '@angular/router';
import { catchError } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class SeguridadService {

  private loginUrl = 'http://localhost:8080/login';  // URL to web api
  private router : Router;

  constructor(private http: HttpClient) { }

  public getAuth(usuario: Usuario): void {
    console.log('cedula',usuario.cedula);
    console.log('pass',usuario.password);

    this.http.post<Observable<boolean>>(this.loginUrl, usuario, httpOptions).pipe(catchError(e => {
      this.noAutorizado(e);
      return throwError(e);
    }));
  }

  private noAutorizado(e): boolean {
    if(e.status==401 || e.status == 403){
      this.router.navigate(['/login']);
      return true;
    }
    return false;
  }
}
