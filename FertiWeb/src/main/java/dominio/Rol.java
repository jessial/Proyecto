package dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rol {

	private Long codigo;
	private String nombre;
	private boolean estado;

}
