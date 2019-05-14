import { Parcela } from 'src/app/dominio/parcela';
import { DTOElementoXAnalisis } from './dto-elemento';
export class DTOAnalisis {
    codigoAnalisis: number;
    parcela: Parcela;
    fechaAnalisis: string;
    elementos: DTOElementoXAnalisis[];
}
