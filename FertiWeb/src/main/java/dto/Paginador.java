package dto;

import lombok.Data;

@Data
public class Paginador {

	private int tamano;
	private long totalElementos;
	private int totalPaginas;
	private int numeroPagina;
	
}
