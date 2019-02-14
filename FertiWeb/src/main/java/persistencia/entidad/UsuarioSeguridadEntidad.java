package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "Usuario_Seguridad")
@Data
public class UsuarioSeguridadEntidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	@Column(unique = true)
	private String nombreUsuario;
	
	private String password;
	
	private boolean estado;

}
