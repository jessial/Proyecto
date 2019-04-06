import { Parcela } from './parcela';
import { ElementoXAnalisis } from './elemento-x-analisis';

export class Analisis {

    public codigoAnalisis: number;
    public parcela: Parcela;
    public fechaAnalisis: Date;
    public elementos: ElementoXAnalisis[];
}
