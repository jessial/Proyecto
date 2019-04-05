package dominio;

public class Elemento {

	private Long codigoElemento;
	private String elemento;

	public Elemento(Long codigoElemento, String elemento) {
		this.codigoElemento = codigoElemento;
		this.elemento = elemento;
	}

	public Elemento() {
	}

	public Long getCodigoElemento() {
		return codigoElemento;
	}

	public String getElemento() {
		return elemento;
	}

	public void setCodigoElemento(Long codigoElemento) {
		this.codigoElemento = codigoElemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

}
