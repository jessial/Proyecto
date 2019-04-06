package persistencia.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "Parcela")
@SequenceGenerator(name = "seq_parcela", sequenceName = "seq_parcela", initialValue = 10, allocationSize = 1)

public class ParcelaEntidad {

	@Id
	@Column(name = "par_codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_parcela")
	private Long codigoParcela;
	@Column(name = "par_codigo_cultivo_sembrado")
	private Long codigoCultivoSembrado;
	@Column(name = "par_codigo_lugar")
	private Long codigoLugar;
	@Column(name = "par_area", nullable = false)
	private double area;
	@Column(name = "par_fecha_posible_siembra")
	private Date fechaPosibleSiembra;

	public ParcelaEntidad(Long codigoParcela, Long codigoCultivoSembrado, Long codigoLugar, double area,
			Date fechaPosibleSiembra) {
		this.codigoParcela = codigoParcela;
		this.codigoCultivoSembrado = codigoCultivoSembrado;
		this.codigoLugar = codigoLugar;
		this.area = area;
		this.fechaPosibleSiembra = fechaPosibleSiembra;
	}

	public ParcelaEntidad() {
	}

	public Long getCodigoParcela() {
		return codigoParcela;
	}

	public void setCodigoParcela(Long codigoParcela) {
		this.codigoParcela = codigoParcela;
	}

	public Long getCodigoCultivoSembrado() {
		return codigoCultivoSembrado;
	}

	public void setCodigoCultivoSembrado(Long codigoCultivoSembrado) {
		this.codigoCultivoSembrado = codigoCultivoSembrado;
	}

	public Long getCodigoLugar() {
		return codigoLugar;
	}

	public void setCodigoLugar(Long codigoLugar) {
		this.codigoLugar = codigoLugar;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public Date getFechaPosibleSiembra() {
		return fechaPosibleSiembra;
	}

	public void setFechaPosibleSiembra(Date fechaPosibleSiembra) {
		this.fechaPosibleSiembra = fechaPosibleSiembra;
	}

}
