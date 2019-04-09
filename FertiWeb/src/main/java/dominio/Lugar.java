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
	private Long codigoUsuario;
	private String ubicacion;

}
