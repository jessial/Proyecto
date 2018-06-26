package dominio;

import lombok.AccessLevel;
import lombok.Getter;

@Getter (AccessLevel.PRIVATE)
public class TipoUsuario {

	private int codigo;
	private String descripcion;
	
}
