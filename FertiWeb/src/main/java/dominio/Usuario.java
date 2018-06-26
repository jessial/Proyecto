package dominio;

import lombok.AccessLevel;
import lombok.Getter;

@Getter (AccessLevel.PRIVATE)
public class Usuario {
	
	private Long cedula;
	private String nombre;
	private String apellido;
	private Long telefono;
	private String email;
	
}
