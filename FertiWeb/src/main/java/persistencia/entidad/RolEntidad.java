package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "Rol")
@Data
public class RolEntidad {
	
	@Id
	@Column(name="rol_codigo")
	private int codigo;
	@Column(name="rol_nombre")
	private String nombre;
	
}
