package dto;

import java.util.List;

import lombok.Data;

@Data
public class DTOAnalisisPaginado {

	private List<DTOAnalisis> analisis;
	private Paginador paginador;
	
}
