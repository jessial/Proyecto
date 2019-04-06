package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Unidad")

public class UnidadEntidad {

	@Id
	@Column(name = "uni_codigo")
	private Long codigoUnidad;
	@Column(name = "uni_nombre")
	private String nombreUnidad;

	public UnidadEntidad(Long codigoUnidad, String nombreUnidad) {
		this.codigoUnidad = codigoUnidad;
		this.nombreUnidad = nombreUnidad;
	}

	public UnidadEntidad() {
	}

	public Long getCodigoUnidad() {
		return codigoUnidad;
	}

	public void setCodigoUnidad(Long codigoUnidad) {
		this.codigoUnidad = codigoUnidad;
	}

	public String getNombreUnidad() {
		return nombreUnidad;
	}

	public void setNombreUnidad(String nombreUnidad) {
		this.nombreUnidad = nombreUnidad;
	}

}
