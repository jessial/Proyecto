package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;

@Entity(name = "Fuente")
@Getter
public class FuenteEntidad {
	
	@Id
	@Column(name="fue_codigo")
	private int codigo;
	@Column(name="fue_producto",nullable = false)
	private String producto;
	
}
