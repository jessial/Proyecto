package dominio;

import lombok.AccessLevel;
import lombok.Getter;

@Getter (AccessLevel.PRIVATE)
public class Lote {

	private Usuario usuario;
	private int codigo;
	private String ubicacion;
	private int area;
	
}
