import { Injectable } from '@angular/core';
import {
  HttpEvent, HttpInterceptor, HttpHandler, HttpRequest
} from '@angular/common/http';

import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { UtilidadService } from '../servicios/utilidad.service';
import { SeguridadService } from '../seguridad/servicios/seguridad.service';
import { Router } from '@angular/router';


/** Pass untouched request through to the next request handler. */
@Injectable()
export class RespuestaInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler):
    Observable<HttpEvent<any>> {
    return next.handle(req).pipe(catchError(err => {
        if(err.status == 401 || err.status == 403){
            if(this.seguridadService.isAuthenticated()){
                this.seguridadService.logout();
            }
            this.router.navigate(['/login']);
        }
        return throwError(err);
    }));
  }

  constructor(private utilidad: UtilidadService, private seguridadService: SeguridadService, private router: Router) { }

}