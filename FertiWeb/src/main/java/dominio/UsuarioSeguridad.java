package dominio;

import lombok.Data;

@Data
public class UsuarioSeguridad {
	
	private String nombreUsuario;
	private String password;
	private boolean estado;

}
