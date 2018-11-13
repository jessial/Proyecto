import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LocalService {

  private subject = new Subject<any>();

  enviarAccion(tipo: string) {
    this.subject.next({ accion: tipo });
  }

  limpiarAccion() {
    this.subject.next();
  }

  obtenerAccion(): Observable<any> {
    return this.subject.asObservable();
  }

  constructor() { }
}
