package dto;

import dominio.Unidad;
import lombok.Data;

@Data
public class DTOFuenteXRecomendacion {
	
	private Long codigoFuenteXRecomendacion;
	private DTOFuente fuente;
	private Double cantidad;
	private Unidad unidad;
	private Long codigoRecomendacion;

}
