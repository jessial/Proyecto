package dominio;

public class Usuario {

	private Long cedula;
	private Long codigoRol;
	private String nombre;
	private String apellido;
	private Long telefono;
	private String email;
	private String password;

	public Usuario(Long cedula, Long codigoRol, String nombre, String apellido, Long telefono, String email,
			String password) {
		this.cedula = cedula;
		this.codigoRol = codigoRol;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
	}

	public Usuario() {
	}

	public Long getCedula() {
		return cedula;
	}

	public Long getCodigoRol() {
		return codigoRol;
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

	public String getPassword() {
		return password;
	}

}
