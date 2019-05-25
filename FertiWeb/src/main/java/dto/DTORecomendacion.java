package dto;

import java.util.Date;
import java.util.List;

import dominio.Analisis;
import lombok.Data;

@Data
public class DTORecomendacion {

	private Long codigoRecomendacion;
	private Analisis analisis;
	private Date fechaRecomendacion;
	private List<DTOFuenteXRecomendacion> recomendacionXFuente;

}
