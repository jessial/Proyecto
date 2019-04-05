package dominio;

public class TipoCultivo {

	private Long codigoTipoCultivo;
	private String nombre;
	private String variedad;
	private boolean estado;

	public TipoCultivo() {
	}

	public TipoCultivo(Long codigoTipoCultivo, String nombre, String variedad, boolean estado) {
		this.codigoTipoCultivo = codigoTipoCultivo;
		this.nombre = nombre;
		this.variedad = variedad;
		this.estado = estado;
	}

	public Long getCodigoTipoCultivo() {
		return codigoTipoCultivo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getVariedad() {
		return variedad;
	}

	public boolean isEstado() {
		return estado;
	}

}
