package dominio;

public class Requerimiento {

	private Long codigoRequerimiento;
	private TipoCultivo tipoCultivo;
	private Elemento elemento;
	private boolean estado;
	private double cantidad;
	private Unidad unidad;

	public Requerimiento(Long codigoRequerimiento, TipoCultivo tipoCultivo, Elemento elemento, boolean estado,
			double cantidad, Unidad unidad) {
		this.codigoRequerimiento = codigoRequerimiento;
		this.tipoCultivo = tipoCultivo;
		this.elemento = elemento;
		this.estado = estado;
		this.cantidad = cantidad;
		this.unidad = unidad;
	}

	public Requerimiento() {
	}

	public Long getCodigoRequerimiento() {
		return codigoRequerimiento;
	}

	public TipoCultivo getTipoCultivo() {
		return tipoCultivo;
	}

	public Elemento getElemento() {
		return elemento;
	}

	public boolean isEstado() {
		return estado;
	}

	public double getCantidad() {
		return cantidad;
	}

	public Unidad getUnidad() {
		return unidad;
	}

}
