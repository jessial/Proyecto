package dto;

import dominio.Elemento;
import dominio.Unidad;
import lombok.Data;

@Data
public class DTOTipoFuente {

	private Long codigo;
	private String nombre;
	private Double aporte;
	private Unidad unidad;
	private Boolean estado;
	private Elemento elemento;
}
