package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
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

}