package dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipoCultivo {

	private Long codigoTipoCultivo;
	private String nombre;
	private String variedad;
	private boolean estado;

}
