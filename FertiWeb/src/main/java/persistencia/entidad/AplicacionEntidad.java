package persistencia.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Aplicacion")
public class AplicacionEntidad {

	@Id
	@Column(name="apli_codigo")
	private int codigo;
	@Column(name="apli_producto",nullable = false)
	private String producto;
	@Column(name="apli_cantidad",nullable = false)
	private Double cantidad;
	@Column(name="apli_fechaAplicacion",nullable = false)
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
