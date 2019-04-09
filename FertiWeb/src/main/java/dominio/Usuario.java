package dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {

	private Long cedula;
	private Long codigoRol;
	private String nombre;
	private String apellido;
	private Long telefono;
	private String email;
	private String password;

}
