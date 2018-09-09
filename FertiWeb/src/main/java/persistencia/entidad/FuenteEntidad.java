package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "Fuente")
@Data
public class FuenteEntidad {
	
	@Id
	@Column(name="fue_codigo")
	private Long codigoFuente;
	@Column(name="fue_codigo_tipo_fuente")
	private Long codigoTipoFuente;
	@Column(name="fue_producto",nullable = false)
	private String producto;
	
}
