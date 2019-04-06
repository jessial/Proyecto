import { TipoCultivo } from './tipo-cultivo';
import { Lugar } from './lugar';

export class Parcela {
    public codigoParcela: number;
    public lugar: Lugar;
    public tipoCultivo: TipoCultivo;
    public area: number;
    public fechaSiembra: Date;
}
