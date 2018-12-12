package dominio;

import lombok.Data;

@Data
public class Requerimiento {

	private Long codigoRequerimiento;
	private Long codigoTipoCultivo;
	private Long reqCodigoElemento;
	private boolean estado;
	private double cantidad;
	private Long uniCodigo;

}
