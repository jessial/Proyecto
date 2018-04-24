package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Usuario")
public class UsuarioEntidad {

	@Id
	private Long cedula;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String apellido;
	@Column
	private Long telefono;
	@Column
	private String email;
	
	public Long getCedula() {
		return cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public Long getTelefono() {
		return telefono;
	}
	public String getEmail() {
		return email;
	}
	
}