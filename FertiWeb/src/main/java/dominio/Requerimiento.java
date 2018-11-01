package dominio;

import lombok.Data;

@Data
public class Requerimiento {
	
	private Long codigoCultivoSembrado;
	private Long codigoRequerimiento;
	private String nutriente;
	private Double cantidad;
	private boolean estado;
}
