package dominio;

import lombok.Data;

@Data
public class Recomendacion {
	
	private Long codigoRecomendacion;
	private Long codigoParcela;
	private String producto;
	private Double cantidad;
	
}
