package dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Fuente {

	private Long codigoFuente;
	private Long codigoTipoFuente;
	private String producto;
	private boolean estado;

}
