package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity(name = "TipoFuente")
@Data
@SequenceGenerator(name = "seq_tf", sequenceName = "seq_tf", initialValue = 10, allocationSize = 1)
public class TipoFuenteEntidad {

	@Id
	@Column(name = "tf_codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tf")
	private Long codigo;
	@Column(name = "tf_nombre", nullable = false)
	private String nombre;
	@Column(name = "tf_aporte", nullable = false)
	private double aporte;
	@Column(name = "tf_unidad", nullable = false)
	private Long unidad;
	@Column(name = "tf_estado", nullable = false)
	private boolean estado;

}
