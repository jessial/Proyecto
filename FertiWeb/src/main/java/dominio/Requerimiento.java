package dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Requerimiento {

	private Long codigoRequerimiento;
	private Long codigoTipoCultivo;
	private Long reqCodigoElemento;
	private boolean estado;
	private double cantidad;
	private Long uniCodigo;

}