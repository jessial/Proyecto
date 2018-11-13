package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity(name = "Rol")
@Data
@SequenceGenerator(name="seq_rol", sequenceName="seq_rol", initialValue=10, allocationSize = 1)
public class RolEntidad {
	
	@Id
	@Column(name="rol_codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_rol")
	private Long codigo;
	@Column(name="rol_nombre")
	private String nombre;
	@Column(name="rol_estado")
	private boolean estado;
	
}
