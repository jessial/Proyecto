package dominio;

import lombok.AccessLevel;
import lombok.Getter;

@Getter (AccessLevel.PRIVATE)
public class Requerimiento {
	
	private int codigo;
	private TipoCultivo tipoCultivo;
	
}
