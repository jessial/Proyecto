package dto;

import lombok.Data;

@Data

public class RequerimientoPorCultivo {
	
	private Long codigoRequerimiento;
	private double cantidad;
	private String cultivo;
	private String variedad;
	private boolean estado;
	private String elemento;
	private String unidad;
	
	public RequerimientoPorCultivo(Long codigoRequerimiento, double cantidad, String cultivo, String variedad,
			boolean estado, String elemento, String unidad) {
		this.codigoRequerimiento = codigoRequerimiento;
		this.cantidad = cantidad;
		this.cultivo = cultivo;
		this.variedad = variedad;
		this.estado = estado;
		this.elemento = elemento;
		this.unidad = unidad;
	}
	
	
	
}
