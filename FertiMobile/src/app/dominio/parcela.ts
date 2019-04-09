import { Lugar } from './lugar';
import { TipoCultivo } from './tipo-cultivo';

export class Parcela {
    codigoParcela: number;
    lugar: Lugar;
    tipoCultivo: TipoCultivo;
    area: number;
    fechaSiembra: string;
}
