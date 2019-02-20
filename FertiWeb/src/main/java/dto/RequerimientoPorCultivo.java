package dto;

import lombok.Value;

@Value
public class RequerimientoPorCultivo {

	private Long codigoRequerimiento;
	private double cantidad;
	private Long codigoTipoCultivo;
	private String cultivo;
	private String variedad;
	private boolean estado;
	private Long codigoElemento;
	private String elemento;
	private Long codigoUnidad;
	private String unidad;

}
