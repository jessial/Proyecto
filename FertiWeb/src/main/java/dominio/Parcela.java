package dominio;

import java.util.Date;

import lombok.Data;

@Data
public class Parcela {

	private Long codigoLugar;
	private Long codigoCultivoSembrado;
	private Long codigoParcela;
	private int area;
	private Date fechaSiembra;
	
}
