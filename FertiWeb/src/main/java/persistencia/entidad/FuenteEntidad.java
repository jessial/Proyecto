
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

@Entity(name = "Fuente")
@SequenceGenerator(name = "seq_fuente", sequenceName = "seq_fuente", initialValue = 10, allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FuenteEntidad {

	@Id
	@Column(name = "fue_codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fuente")
	private Long codigoFuente;
	@Column(name = "fue_codigo_tipo_fuente")
	private Long codigoTipoFuente;
	@Column(name = "fue_producto", nullable = false)
	private String producto;
	@Column(name = "estado", nullable = false)
	private boolean estado;

}
