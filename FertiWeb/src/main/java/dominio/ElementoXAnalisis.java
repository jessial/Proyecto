package dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ElementoXAnalisis {

	private Long codigoAnalisis;
	private Elemento elemento;
	private Double cantidad;
	private Unidad unidad;
}