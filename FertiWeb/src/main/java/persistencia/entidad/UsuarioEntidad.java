package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Usuario")
public class UsuarioEntidad {

	@Id
	@Column(nullable = false)
	private Long cedula;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String apellido;
	@Column
	private Long telefono;
	@Column
	private String email;
	
}