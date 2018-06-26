package dominio;

import lombok.AccessLevel;
import lombok.Getter;

@Getter (AccessLevel.PRIVATE)
public class TipoFuente {
	
	private int codigo;
	private String nombre;
	private double aporte;
	
}
