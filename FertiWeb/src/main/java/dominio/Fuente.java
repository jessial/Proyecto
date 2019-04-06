package dominio;

public class Fuente {

	private Long codigoFuente;
	private TipoFuente tipoFuente;
	private String producto;
	private boolean estado;

	public Fuente() {
	}

	public Fuente(Long codigoFuente, TipoFuente tipoFuente, String producto, boolean estado) {
		this.codigoFuente = codigoFuente;
		this.tipoFuente = tipoFuente;
		this.producto = producto;
		this.estado = estado;
	}

	public Long getCodigoFuente() {
		return codigoFuente;
	}

	public TipoFuente getTipoFuente() {
		return tipoFuente;
	}

	public String getProducto() {
		return producto;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setCodigoFuente(Long codigoFuente) {
		this.codigoFuente = codigoFuente;
	}

	public void setTipoFuente(TipoFuente tipoFuente) {
		this.tipoFuente = tipoFuente;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
