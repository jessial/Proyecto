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

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setAporte(Double aporte) {
		this.aporte = aporte;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

}
