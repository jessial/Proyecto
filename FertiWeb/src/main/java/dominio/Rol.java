package dominio;

import lombok.Data;

@Data
public class Rol {
	
	private Long codigo;
	private String nombre;
	private boolean estado;
}
