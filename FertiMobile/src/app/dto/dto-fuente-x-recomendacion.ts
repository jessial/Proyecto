import { DTOFuente } from './dto-fuente';
import { Unidad } from 'src/app/dominio/unidad';
export class DTOFuenteXRecomendacion {
    codigoFuenteXRecomendacion: number;
    fuente: DTOFuente;
    cantidad: number;
    unidad: Unidad;
    codigoRecomendacion: number;
}
