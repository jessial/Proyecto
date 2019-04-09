package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Lugar")
@SequenceGenerator(name = "seq_lugar", sequenceName = "seq_lugar", initialValue = 10, allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LugarEntidad {

	@Id
	@Column(name = "lug_codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_lugar")
	private Long codigoLugar;
	@Column(name = "lug_nombre")
	private String nombre;
	@Column(name = "lug_codigo_usuario")
	private Long codigoUsuario;
	@Column(name = "lug_ubicacion")
	private String ubicacion;

}
