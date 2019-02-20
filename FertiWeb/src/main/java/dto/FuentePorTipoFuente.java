package dto;

import lombok.Value;

@Value
public class FuentePorTipoFuente {

	private Long codigoFuente;
	private boolean estado;
	private String producto;
	private Long codigoTipoFuente;
	private String tipoFuente;
}
