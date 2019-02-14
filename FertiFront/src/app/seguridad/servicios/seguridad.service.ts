import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usuario } from '../../calses_dominio/usuario';
import { Observable, of } from 'rxjs';
import { Router } from '@angular/router';

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
    this.http.post<Observable<boolean>>(this.loginUrl, usuario).subscribe(isValid => {
      if (isValid) {
          sessionStorage.setItem(
            'token', 
            btoa(usuario.cedula + ':' + usuario.password)
          );
      this.router.navigate(['/']);
      return true;
      } else {
          alert("Authentication failed.");
          return false;
      }
  });
  }


}
