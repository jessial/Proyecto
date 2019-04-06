package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "Rol")
@SequenceGenerator(name = "seq_rol", sequenceName = "seq_rol", initialValue = 10, allocationSize = 1)
public class RolEntidad {

	@Id
	@Column(name = "rol_codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_rol")
	private Long codigo;
	@Column(name = "rol_nombre")
	private String nombre;
	@Column(name = "rol_estado")
	private boolean estado;

	public RolEntidad(Long codigo, String nombre, boolean estado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.estado = estado;
	}

	public RolEntidad() {
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
