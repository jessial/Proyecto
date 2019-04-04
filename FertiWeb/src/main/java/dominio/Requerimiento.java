package dominio;

import lombok.Data;

@Data
public class Requerimiento {

	private Long codigoRequerimiento;
	private TipoCultivo tipoCultivo;
	private Elemento elemento;
	private boolean estado;
	private double cantidad;
	private Unidad unidad;

}
