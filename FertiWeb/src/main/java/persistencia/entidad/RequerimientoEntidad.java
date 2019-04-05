package persistencia.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "Requerimiento")
@SequenceGenerator(name = "seq_req", sequenceName = "seq_req", initialValue = 10, allocationSize = 1)

public class RequerimientoEntidad implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "req_codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_req")
	private Long codigoRequerimiento;
	@Column(name = "req_codigo_tipo_cultivo", nullable = false)
	private Long codigoTipoCultivo;
	@Column(name = "req_elemento")
	private Long reqCodigoElemento;
	@Column(name = "req_estado", nullable = false)
	private boolean estado;
	@Column(name = "req_cantidad", nullable = false)
	private double cantidad;
	@Column(name = "uni_codigo")
	private Long uniCodigo;

	public RequerimientoEntidad(Long codigoRequerimiento, Long codigoTipoCultivo, Long reqCodigoElemento,
			boolean estado, double cantidad, Long uniCodigo) {
		this.codigoRequerimiento = codigoRequerimiento;
		this.codigoTipoCultivo = codigoTipoCultivo;
		this.reqCodigoElemento = reqCodigoElemento;
		this.estado = estado;
		this.cantidad = cantidad;
		this.uniCodigo = uniCodigo;
	}

	public RequerimientoEntidad() {
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getCodigoRequerimiento() {
		return codigoRequerimiento;
	}

	public Long getCodigoTipoCultivo() {
		return codigoTipoCultivo;
	}

	public Long getReqCodigoElemento() {
		return reqCodigoElemento;
	}

	public boolean isEstado() {
		return estado;
	}

	public double getCantidad() {
		return cantidad;
	}

	public Long getUniCodigo() {
		return uniCodigo;
	}

	public void setCodigoRequerimiento(Long codigoRequerimiento) {
		this.codigoRequerimiento = codigoRequerimiento;
	}

	public void setCodigoTipoCultivo(Long codigoTipoCultivo) {
		this.codigoTipoCultivo = codigoTipoCultivo;
	}

	public void setReqCodigoElemento(Long reqCodigoElemento) {
		this.reqCodigoElemento = reqCodigoElemento;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public void setUniCodigo(Long uniCodigo) {
		this.uniCodigo = uniCodigo;
	}

}
