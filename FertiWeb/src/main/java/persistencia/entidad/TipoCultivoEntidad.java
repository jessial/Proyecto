package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "TipoCultivo")
public class TipoCultivoEntidad {
	
	@Id
	@Column(name="tc_codigo")
	private int codigo;
	@Column(name="tc_variedad",nullable = false)
	private String variedad;
	@Column(name="tc_nombre",nullable = false)
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
