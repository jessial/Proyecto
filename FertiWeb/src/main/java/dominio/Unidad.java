package dominio;

public class Unidad {

	private Long codigoUnidad;
	private String nombreUnidad;

	public Unidad(Long codigoUnidad, String nombreUnidad) {
		this.codigoUnidad = codigoUnidad;
		this.nombreUnidad = nombreUnidad;
	}

	public Unidad() {
	}

	public Long getCodigoUnidad() {
		return codigoUnidad;
	}

	public String getNombreUnidad() {
		return nombreUnidad;
	}

}
