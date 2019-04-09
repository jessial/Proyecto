package dto;

import dominio.Elemento;
import dominio.Unidad;
import lombok.Data;

@Data
public class DTOElementoXAnalisis {

	private Long codigoAnalisis;
	private Elemento elemento;
	private Double cantidad;
	private Unidad unidad;
}
