package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "TipoFuente")
public class TipoFuenteEntidad {
	
	@Id
	private int codigo;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
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
