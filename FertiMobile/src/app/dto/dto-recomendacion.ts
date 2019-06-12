import { DTOFuenteXRecomendacion } from './dto-fuente-x-recomendacion';
import { DTOAnalisis } from './dto-analisis';

export class DTORecomendacion {
    codigoRecomendacion: number;
    analisis: DTOAnalisis;
    fechaRecomendacion: string;
    recomendacionXFuente: DTOFuenteXRecomendacion[];
}
