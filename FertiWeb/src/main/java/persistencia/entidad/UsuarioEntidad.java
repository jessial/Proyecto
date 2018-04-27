package persistencia.entidad;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "Usuario")
public class UsuarioEntidad {

	@Id
	@Column(name="usu_cedula")
	private Long cedula;
	@Column(name="usu_nombre",nullable = false)
	private String nombre;
	@Column(name="usu_apellido" ,nullable = false)
	private String apellido;
	@Column(name="usu_telefono")
	private Long telefono;
	@Column(name="usu_email")
	private String email;
	@OneToMany
	private List<TipoUsuarioEntidad> tipoUsuario;
	
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