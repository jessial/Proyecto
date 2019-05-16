package dominio;

import lombok.Data;

@Data
public class Recomendacion {
	
	private Long codigoRecomendacion;
	private Double cantidad;
	private Long codigoFuente;
	private Long codigoAnalisis;
	private Long codigoUnidad;
	
}
