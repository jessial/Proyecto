package dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Requerimiento {

	private Long codigoRequerimiento;
	private TipoCultivo tipoCultivo;
	private Elemento elemento;
	private boolean estado;
	private double cantidad;
	private Unidad unidad;

}