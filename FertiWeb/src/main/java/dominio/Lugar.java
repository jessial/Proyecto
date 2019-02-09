package dominio;

import lombok.Data;

@Data
public class Lugar {
	private Long codigoLugar;
	private String nombre;
	private Long codigoUsuario;
	private String ubicacion;
}
