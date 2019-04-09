package dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class DTOAnalisis {
	
	private Long codigoAnalisis;
	private DTOParcela parcela;
	private Date fechaAnalisis;
	private List<DTOElementoXAnalisis> elementos;
	
}
