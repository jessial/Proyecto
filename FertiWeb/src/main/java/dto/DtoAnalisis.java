package dto;

import java.util.Date;
import java.util.List;

import dominio.ElementoXAnalisis;
import dominio.Parcela;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoAnalisis {
	
	private Long codigoAnalisis;
	private DtoParcela dtoParcela;
	private Date fechaAnalisis;
	private List<ElementoXAnalisis> elementos;
	
}
