package dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ElementoXAnalisis {

	private Long elementoXAnalisisCodigo;
	private Long codigoAnalisis;
	private Long codigoElemento;
	private Double cantidad;
	private Long codigoUnidad;
}