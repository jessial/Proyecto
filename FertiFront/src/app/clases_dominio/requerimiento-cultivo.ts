import { Unidad } from './unidad';
import { TipoCultivo } from './tipo-cultivo';
import { Elemento } from './elemento';

export class RequerimientoCultivo {

    public codigoRequerimiento: number;
    public tipoCultivo: TipoCultivo;
    public elemento: Elemento;
    public estado: boolean;
    public cantidad: number;
    public unidad: Unidad;
}
