package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "Lugar")
@SequenceGenerator(name = "seq_lugar", sequenceName = "seq_lugar", initialValue = 10, allocationSize = 1)
public class LugarEntidad {

	@Id
	@Column(name = "lug_codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_lugar")
	private Long codigoLugar;
	@Column(name = "lug_nombre")
	private String nombre;
	@Column(name = "lug_codigo_usuario")
	private Long codigoUsuario;
	@Column(name = "lug_ubicacion")
	private String ubicacion;

	public LugarEntidad(Long codigoLugar, String nombre, Long codigoUsuario, String ubicacion) {
		this.codigoLugar = codigoLugar;
		this.nombre = nombre;
		this.codigoUsuario = codigoUsuario;
		this.ubicacion = ubicacion;
	}

	public LugarEntidad() {
	}

	public Long getCodigoLugar() {
		return codigoLugar;
	}

	public void setCodigoLugar(Long codigoLugar) {
		this.codigoLugar = codigoLugar;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Long codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

}
