package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Usuario")
public class UsuarioEntidad {

	@Id
	@Column(name = "usu_cedula")
	private Long cedula;
	@Column(name = "usu_codigo_rol")
	private Long codigoRol;
	@Column(name = "usu_nombre", nullable = false)
	private String nombre;
	@Column(name = "usu_apellido", nullable = false)
	private String apellido;
	@Column(name = "usu_telefono")
	private Long telefono;
	@Column(name = "usu_email")
	private String email;
	@Column(name = "usu_password")
	private String password;

	public UsuarioEntidad(Long cedula, Long codigoRol, String nombre, String apellido, Long telefono, String email,
			String password) {
		this.cedula = cedula;
		this.codigoRol = codigoRol;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
	}

	public UsuarioEntidad() {
	}

	public Long getCedula() {
		return cedula;
	}

	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}

	public Long getCodigoRol() {
		return codigoRol;
	}

	public void setCodigoRol(Long codigoRol) {
		this.codigoRol = codigoRol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}