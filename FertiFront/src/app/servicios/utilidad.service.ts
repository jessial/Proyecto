import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { NzNotificationService } from 'ng-zorro-antd';

@Injectable({
  providedIn: 'root'
})
export class UtilidadService {

  constructor(private mensajeComponent: NzNotificationService) {
  }

  handleError(error: Response) {
    return Observable.throw(error || 'Server error');
  }

  public mensajeExito(titulo: string, mensaje: string) {
    this.mensajeComponent.success(titulo, mensaje);
  }

  public mensajeError(mensaje: string) {
    this.mensajeComponent.error('Ocurrio un Error', 'Ocurrio un error consultando el servidor por favor verifique su conexion a internet');
  }

  public mensajeAlerta(titulo: string, mensaje: string) {
    this.mensajeComponent.warning(titulo, mensaje);
  }
}
