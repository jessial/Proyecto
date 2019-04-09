package dto;

import dominio.TipoFuente;
import lombok.Data;

@Data
public class DTOFuente {

	private Long codigoFuente;
	private TipoFuente tipoFuente;
	private String producto;
	private boolean estado;
}
