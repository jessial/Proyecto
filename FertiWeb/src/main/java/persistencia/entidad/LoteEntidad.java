package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Lote")
public class LoteEntidad {

	@Id
	private int codigo;
	@Column(nullable = false)
	private String ubicacion;
	@Column(nullable = false)
	private int area;
	@Column(nullable = false)
	private UsuarioEntidad usuario;
	
	public int getCodigo() {
		return codigo;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public int getArea() {
		return area;
	}
	public UsuarioEntidad getUsuario() {
		return usuario;
	}
}
