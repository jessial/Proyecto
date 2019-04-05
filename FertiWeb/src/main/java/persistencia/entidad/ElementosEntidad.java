package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Elementos")
public class ElementosEntidad {

	@Id
	@Column(name = "codigo")
	private Long codigoElemento;
	@Column(name = "elemento")
	private String elemento;

	public ElementosEntidad() {
	}

	public ElementosEntidad(Long codigoElemento, String elemento) {
		this.codigoElemento = codigoElemento;
		this.elemento = elemento;
	}

	public void setCodigoElemento(Long codigoElemento) {
		this.codigoElemento = codigoElemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public Long getCodigoElemento() {
		return codigoElemento;
	}

	public String getElemento() {
		return elemento;
	}

}
