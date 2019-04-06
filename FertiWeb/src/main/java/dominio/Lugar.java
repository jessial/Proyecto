package dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Lugar {

	private Long codigoLugar;
	private String nombre;
	private Usuario usuario;
	private String ubicacion;
	private Long codigoUsuario;


	public Lugar(Long codigoLugar, String nombre, Usuario usuario, String ubicacion) {
		this.codigoLugar = codigoLugar;
		this.nombre = nombre;
		this.usuario = usuario;
		this.ubicacion = ubicacion;
	}

}
