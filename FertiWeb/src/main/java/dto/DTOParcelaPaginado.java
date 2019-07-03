package dto;

import java.util.List;

import lombok.Data;

@Data
public class DTOParcelaPaginado {

	private List<DTOParcela> parcela;
	private Paginador paginador;

}
