package dominio;

import java.util.Date;

import lombok.Data;

@Data
public class Analisis {

	private Long codigoAnalisis;
	private Long codigoParcela;
	private Date fechaAnalisis;
	private Long codigoElemento;
	private Double cantidad;
	private Long codigoUnidad;

}
