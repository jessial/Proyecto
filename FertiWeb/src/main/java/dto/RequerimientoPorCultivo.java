package dto;

import lombok.Value;

@Value
public class RequerimientoPorCultivo {

	private Long codigoRequerimiento;
	private double cantidad;
	private String cultivo;
	private String variedad;
	private boolean estado;
	private String elemento;
	private String unidad;

}
