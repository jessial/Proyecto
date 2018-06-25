package persistencia.entidad;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Getter;

@Entity(name = "Usuario")
@Getter (AccessLevel.PRIVATE)
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
	
}