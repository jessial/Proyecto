package dominio;

import java.util.Date;

public class Analisis {

	private Long codigoAnalisis;
	private Parcela parcela;
	private Date fechaAnalisis;
	private Elemento elemento;
	private Double cantidad;
	private Unidad unidad;

	public Analisis(Long codigoAnalisis, Parcela parcela, Date fechaAnalisis, Elemento elemento, Double cantidad,
			Unidad unidad) {
		this.codigoAnalisis = codigoAnalisis;
		this.parcela = parcela;
		this.fechaAnalisis = fechaAnalisis;
		this.elemento = elemento;
		this.cantidad = cantidad;
		this.unidad = unidad;
	}

	public Analisis() {
	}

	public Long getCodigoAnalisis() {
		return codigoAnalisis;
	}

	public void setCodigoAnalisis(Long codigoAnalisis) {
		this.codigoAnalisis = codigoAnalisis;
	}

	public Parcela getParcela() {
		return parcela;
	}

	public void setParcela(Parcela parcela) {
		this.parcela = parcela;
	}

	public Date getFechaAnalisis() {
		return fechaAnalisis;
	}

	public void setFechaAnalisis(Date fechaAnalisis) {
		this.fechaAnalisis = fechaAnalisis;
	}

	public Elemento getElemento() {
		return elemento;
	}

	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

}
