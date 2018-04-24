package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "TipoCultivo")
public class TipoCultivoEntidad {
	
	@Id
	private int codigo;
	@Column(nullable = false)
	private String variedad;
	@Column(nullable = false)
	private String nombre;
	
	public int getCodigo() {
		return codigo;
	}
	public String getVariedad() {
		return variedad;
	}
	public String getNombre() {
		return nombre;
	}
}
