import { DTOAnalisis } from './dto-analisis';
import { DTOFuente } from './dto-fuente';

export class FuenteParaRecomendacion {
    dtoAnalisis: DTOAnalisis;
    nitrogeno: DTOFuente;
    fosforo: DTOFuente;
    potasio: DTOFuente;
}
