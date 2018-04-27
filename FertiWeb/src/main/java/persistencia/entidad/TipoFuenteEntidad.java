package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "TipoFuente")
public class TipoFuenteEntidad {
	
	@Id
	@Column(name="tf_codigo")
	private int codigo;
	@Column(name="tf_nombre",nullable = false)
	private String nombre;
	@Column(name="tf_aporte",nullable = false)
	private double aporte;
	
	public int getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public double getAporte() {
		return aporte;
	}
	
}
