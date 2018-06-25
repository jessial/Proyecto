package dominio;

import lombok.AccessLevel;
import lombok.Getter;

@Getter (AccessLevel.PRIVATE)
public class TipoCultivo {
	private int codigo;
	private String variedad;
	private String nombre;
	
}
