package dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipoFuente {

	private Long codigo;
	private String nombre;
	private double aporte;
	private Long unidad;
	private boolean estado;
	private Long codigoElemento;

}
