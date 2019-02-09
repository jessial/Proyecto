package dominio;

import java.util.Date;

import lombok.Data;

@Data
public class Parcela {

	private Long codigoParcela;
	private Long codigoLugar;
	private Long codigoCultivoSembrado;
	private double area;
	private Date fechaPosibleSiembra;

}
