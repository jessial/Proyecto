package dominio;

import java.util.Date;

public class Aplicacion {
	
	private int codigo;
	private String producto;
	private Double cantidad;
	private Date fechaAplicacion;
	
	public int getCodigo() {
		return codigo;
	}
	public String getProducto() {
		return producto;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public Date getFechaAplicacion() {
		return fechaAplicacion;
	}
	
}
