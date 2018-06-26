package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;

@Entity(name = "TipoUsuario")
@Getter
public class TipoUsuarioEntidad {

	@Id
	@Column(name="tu_codigo")
	private int codigo;
	@Column(name="tu_descripcion",nullable = false)
	private String descripcion;
	
}
