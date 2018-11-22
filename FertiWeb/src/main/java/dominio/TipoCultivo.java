package dominio;

import lombok.Data;

@Data
public class TipoCultivo {

	private Long codigoTipoCultivo;
	private String nombre;
	private String variedad;
	private boolean estado;
	

}
