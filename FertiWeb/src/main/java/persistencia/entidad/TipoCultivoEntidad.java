package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "Tipo_Cultivo")
@SequenceGenerator(name = "seq", sequenceName = "seq_cultivo", initialValue = 10, allocationSize = 1)
public class TipoCultivoEntidad {

	@Id
	@Column(name = "cul_codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private Long codigoTipoCultivo;
	@Column(name = "cul_nombre", nullable = false)
	private String nombre;
	@Column(name = "cul_variedad", nullable = false)
	private String variedad;
	@Column(name = "cul_estado", nullable = false)
	private boolean estado;

	public TipoCultivoEntidad(Long codigoTipoCultivo, String nombre, String variedad, boolean estado) {
		this.codigoTipoCultivo = codigoTipoCultivo;
		this.nombre = nombre;
		this.variedad = variedad;
		this.estado = estado;
	}

	public TipoCultivoEntidad() {
	}

	public Long getCodigoTipoCultivo() {
		return codigoTipoCultivo;
	}

	public void setCodigoTipoCultivo(Long codigoTipoCultivo) {
		this.codigoTipoCultivo = codigoTipoCultivo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getVariedad() {
		return variedad;
	}

	public void setVariedad(String variedad) {
		this.variedad = variedad;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
