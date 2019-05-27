import { Injectable } from '@angular/core';
import {
  HttpEvent, HttpInterceptor, HttpHandler, HttpRequest
} from '@angular/common/http';

import { Observable } from 'rxjs';

/** Pass untouched request through to the next request handler. */
@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler):
    Observable<HttpEvent<any>> {
        let token = sessionStorage.getItem('token');
        if(token != null){
            const authReq = req.clone({
                headers: req.headers.set('Authorization', 'Bearer ' + token)
              });
              return next.handle(authReq);
        }
    return next.handle(req);
  }
}