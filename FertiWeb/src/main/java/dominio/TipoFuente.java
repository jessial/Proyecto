package dominio;

import lombok.Data;

@Data
public class TipoFuente {
	
	private Long codigo;
	private String nombre;
	private Double aporte;
	private Long unidad;
	private Boolean estado;
	
}
