import { DTOTipoFuente } from './dto-tipo-fuente';
export class DTOFuente {
    codigoFuente: number;
    tipoFuente: DTOTipoFuente;
    producto: string;
    estado: boolean;
}
