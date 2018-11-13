package dominio;

import lombok.Data;

@Data
public class Requerimiento {
	
	private Long reqCodigoCultivoSembrado;
	private Long codigoRequerimiento;
	private String nutriente;
	private double cantidad;
	private boolean estado;
}
