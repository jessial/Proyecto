package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "Lugar")
@Data
public class LugarEntidad {
	
	@Id
	@Column(name="lug_codigo")
	private Long codigoLugar;
	@Column(name="lug_codigo_usuario")
	private Long codigoUsuario;
	@Column(name="lug_codigo_ubicacion")
	private String ubicacion;
}
