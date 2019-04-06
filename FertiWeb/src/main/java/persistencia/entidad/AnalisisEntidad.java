package persistencia.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "Analisis")
@SequenceGenerator(name = "seq_analisis", sequenceName = "seq_analisis", initialValue = 10, allocationSize = 1)

public class AnalisisEntidad {

	@Id
	@Column(name = "ana_codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_analisis")
	private Long codigoAnalisis;
	@Column(name = "ana_cod_parcela")
	private Long codigoParcela;
	@Column(name = "ana_fechaAnalisis")
	private Date fechaAnalisis;
	@Column(name = "ana_codigo_elemento")
	private Long codigoElemento;
	@Column(name = "ana_cantidad")
	private Double cantidad;
	@Column(name = "ana_codigo_unidad")
	private Long codigoUnidad;

	public AnalisisEntidad(Long codigoAnalisis, Long codigoParcela, Date fechaAnalisis, Long codigoElemento,
			Double cantidad, Long codigoUnidad) {
		this.codigoAnalisis = codigoAnalisis;
		this.codigoParcela = codigoParcela;
		this.fechaAnalisis = fechaAnalisis;
		this.codigoElemento = codigoElemento;
		this.cantidad = cantidad;
		this.codigoUnidad = codigoUnidad;
	}

	public AnalisisEntidad() {
	}

	public Long getCodigoAnalisis() {
		return codigoAnalisis;
	}

	public void setCodigoAnalisis(Long codigoAnalisis) {
		this.codigoAnalisis = codigoAnalisis;
	}

	public Long getCodigoParcela() {
		return codigoParcela;
	}

	public void setCodigoParcela(Long codigoParcela) {
		this.codigoParcela = codigoParcela;
	}

	public Date getFechaAnalisis() {
		return fechaAnalisis;
	}

	public void setFechaAnalisis(Date fechaAnalisis) {
		this.fechaAnalisis = fechaAnalisis;
	}

	public Long getCodigoElemento() {
		return codigoElemento;
	}

	public void setCodigoElemento(Long codigoElemento) {
		this.codigoElemento = codigoElemento;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Long getCodigoUnidad() {
		return codigoUnidad;
	}

	public void setCodigoUnidad(Long codigoUnidad) {
		this.codigoUnidad = codigoUnidad;
	}

}
