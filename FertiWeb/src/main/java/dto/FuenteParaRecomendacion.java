package dto;

import lombok.Data;

@Data
public class FuenteParaRecomendacion {

	private DTOAnalisis dtoAnalisis;
	private DTOFuente nitrogeno;
	private DTOFuente fosforo;
	private DTOFuente potasio;
}
