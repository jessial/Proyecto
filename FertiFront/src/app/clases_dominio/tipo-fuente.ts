import { Unidad } from './unidad';
import { Elemento } from './elemento';

export class TipoFuente {
    public codigo: number;
    public nombre: string;
    public aporte: number;
    public estado: boolean;
    public unidad: Unidad;
    public elemento: Elemento;
}
