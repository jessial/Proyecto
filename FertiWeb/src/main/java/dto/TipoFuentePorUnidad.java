package dto;

import lombok.Value;

@Value
public class TipoFuentePorUnidad {

	private Long codigoTipoFuente;
	private double aporte;
	private boolean estado;
	private String tipoFuente;
	private Long codigoUnidad;
	private String unidad;

}
