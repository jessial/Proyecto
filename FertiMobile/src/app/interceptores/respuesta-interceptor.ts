import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NavController } from '@ionic/angular';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { SeguridadService } from '../servicios/seguridad.service';


/** Pass untouched request through to the next request handler. */
@Injectable()
export class RespuestaInterceptor implements HttpInterceptor {

  constructor(private seguridadService: SeguridadService, private navCtrl: NavController) { }

  intercept(req: HttpRequest<any>, next: HttpHandler):
    Observable<HttpEvent<any>> {
    return next.handle(req).pipe(catchError(err => {
      if (err.status === 401 || err.status === 403) {
        if (this.seguridadService.isAuthenticated()) {
          this.seguridadService.logout();
        }
        this.navCtrl.navigateRoot('/');
      }
      return throwError(err);
    }));
  }

}
