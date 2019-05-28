import { Injectable } from '@angular/core';
import { NzNotificationService } from 'ng-zorro-antd';
import { Observable } from 'rxjs';

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
    this.mensajeComponent.error('Ocurrió un error', 'Ocurrió un error consultando el servidor por favor verifique su conexion a internet');
  }

  public mensajeAlerta(titulo: string, mensaje: string) {
    this.mensajeComponent.warning(titulo, mensaje);
  }

  public mensajeErrorEliminar(mensaje: any): void {
    this.mensajeComponent.error('Ocurrió un error', mensaje);
  }
}
