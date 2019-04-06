package dominio;

import java.util.Date;

public class Parcela {

	private Long codigoParcela;
	private Lugar lugar;
	private TipoCultivo tipoCultivo;
	private double area;
	private Date fechaPosibleSiembra;

	public Parcela(Long codigoParcela, Lugar lugar, TipoCultivo tipoCultivo, double area, Date fechaPosibleSiembra) {
		this.codigoParcela = codigoParcela;
		this.lugar = lugar;
		this.tipoCultivo = tipoCultivo;
		this.area = area;
		this.fechaPosibleSiembra = fechaPosibleSiembra;
	}

	public Parcela() {
	}

	public Long getCodigoParcela() {
		return codigoParcela;
	}

	public void setCodigoParcela(Long codigoParcela) {
		this.codigoParcela = codigoParcela;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public TipoCultivo getTipoCultivo() {
		return tipoCultivo;
	}

	public void setTipoCultivo(TipoCultivo tipoCultivo) {
		this.tipoCultivo = tipoCultivo;
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
