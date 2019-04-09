package dto;

import dominio.Usuario;
import lombok.Data;

@Data
public class DTOLugar {

	private Long codigoLugar;
	private String nombre;
	private Usuario usuario;
	private String ubicacion;

}
