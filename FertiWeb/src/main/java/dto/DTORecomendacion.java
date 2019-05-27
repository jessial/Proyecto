package dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class DTORecomendacion {

	private Long codigoRecomendacion;
	private DTOAnalisis analisis;
	private Date fechaRecomendacion;
	private List<DTOFuenteXRecomendacion> recomendacionXFuente;

}
