package dominio;

import lombok.Data;

@Data
public class FuenteXRecomendacion {

	private Long codigoFuenteXRecomendacion;
	private Long codigoFuente;
	private Double cantidad;
	private Long codigoUnidad;
	private Long codigoRecomendacion;

}
