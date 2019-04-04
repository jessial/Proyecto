package dominio;

public class TipoFuente {

	private Long codigo;
	private String nombre;
	private Double aporte;
	private Unidad unidad;
	private Boolean estado;

	public TipoFuente(Long codigo, String nombre, Double aporte, Unidad unidad, Boolean estado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.aporte = aporte;
		this.unidad = unidad;
		this.estado = estado;
	}

	public TipoFuente() {
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public Double getAporte() {
		return aporte;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public Boolean getEstado() {
		return estado;
	}

}
