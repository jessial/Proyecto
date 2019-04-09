package dto;

import dominio.Elemento;
import dominio.TipoCultivo;
import dominio.Unidad;
import lombok.Data;

@Data
public class DTORequerimiento {

	private Long codigoRequerimiento;
	private TipoCultivo tipoCultivo;
	private Elemento elemento;
	private boolean estado;
	private double cantidad;
	private Unidad unidad;
}
