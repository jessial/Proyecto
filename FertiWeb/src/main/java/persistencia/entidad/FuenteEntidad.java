
package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "Fuente")
@SequenceGenerator(name = "seq_fuente", sequenceName = "seq_fuente", initialValue = 10, allocationSize = 1)

public class FuenteEntidad {

	@Id
	@Column(name = "fue_codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fuente")
	private Long codigoFuente;
	@Column(name = "fue_codigo_tipo_fuente")
	private Long codigoTipoFuente;
	@Column(name = "fue_producto", nullable = false)
	private String producto;
	@Column(name = "estado", nullable = false)
	private boolean estado;

	public FuenteEntidad() {

	}

	public FuenteEntidad(Long codigoFuente, Long codigoTipoFuente, String producto, boolean estado) {
		this.codigoFuente = codigoFuente;
		this.codigoTipoFuente = codigoTipoFuente;
		this.producto = producto;
		this.estado = estado;
	}

	public Long getCodigoFuente() {
		return codigoFuente;
	}

	public Long getCodigoTipoFuente() {
		return codigoTipoFuente;
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

	public void setCodigoTipoFuente(Long codigoTipoFuente) {
		this.codigoTipoFuente = codigoTipoFuente;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
