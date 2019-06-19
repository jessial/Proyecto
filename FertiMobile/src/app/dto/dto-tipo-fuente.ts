import { Unidad } from './../dominio/unidad';
import { Elemento } from '../dominio/elemento';
export class DTOTipoFuente {
    codigo: number;
    nombre: string;
    aporte: number;
    unidad: Unidad;
    estado: boolean;
    elemento: Elemento;
}
