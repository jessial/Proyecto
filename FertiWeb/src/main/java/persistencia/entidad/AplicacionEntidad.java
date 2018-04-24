package persistencia.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Aplicacion")
public class AplicacionEntidad {

	@Id
	private int codigo;
	@Column(nullable = false)
	private String producto;
	@Column(nullable = false)
	private Double cantidad;
	@Column(nullable = false)
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
