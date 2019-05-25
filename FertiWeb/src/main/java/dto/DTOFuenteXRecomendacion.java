package dto;

import dominio.Fuente;
import dominio.Unidad;
import lombok.Data;

@Data
public class DTOFuenteXRecomendacion {
	
	private Long codigoFuenteXRecomendacion;
	private Fuente fuente;
	private Double cantidad;
	private Unidad unidad;
	private Long codigoRecomendacion;

}
