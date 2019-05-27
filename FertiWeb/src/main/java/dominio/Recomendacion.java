package dominio;

import java.util.Date;

import lombok.Data;

@Data
public class Recomendacion {

	private Long codigoRecomendacion;
	private Long codigoAnalisis;
	private Date fechaRecomendacion;
}
