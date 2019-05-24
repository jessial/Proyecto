package dto;

import lombok.Data;

@Data
public class DTOFuente {

	private Long codigoFuente;
	private DTOTipoFuente tipoFuente;
	private String producto;
	private boolean estado;
}
