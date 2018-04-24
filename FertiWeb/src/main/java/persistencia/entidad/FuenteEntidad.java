package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Fuente")
public class FuenteEntidad {
	
	@Id
	private int codigo;
	@Column(nullable = false)
	private String producto;
	
	public int getCodigo() {
		return codigo;
	}
	public String getProducto() {
		return producto;
	}
}
