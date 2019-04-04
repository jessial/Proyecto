package dominio;

import lombok.Data;

@Data
public class Fuente {

	private Long codigoFuente;
	private TipoFuente tipoFuente;
	private String producto;
	private boolean estado;

}
