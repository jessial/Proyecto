
package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.SqlResultSetMapping;

import dto.FuentePorTipoFuente;
import lombok.Data;

@Entity(name = "Fuente")
@Data
@SequenceGenerator(name = "seq_fuente", sequenceName = "seq_fuente", initialValue = 10, allocationSize = 1)
@NamedNativeQuery(name = "FuenteEntidad.getTodos", query = "select f.fue_codigo as codigoFuente, f.estado as estado, f.fue_producto as producto, f.fue_codigo_tipo_fuente as codigoTipoFuente, tf.tf_nombre as tipoFuente from fuente f, tipo_fuente tf where  f.fue_codigo_tipo_fuente = tf.tf_codigo;", resultSetMapping = "FuentePorTipoFuente")
@SqlResultSetMapping(name = "FuentePorTipoFuente", classes = @ConstructorResult(targetClass = FuentePorTipoFuente.class, columns = {
		@ColumnResult(name = "codigoFuente", type = Long.class), @ColumnResult(name = "estado"),
		@ColumnResult(name = "producto"), @ColumnResult(name = "codigoTipoFuente", type = Long.class),
		@ColumnResult(name = "tipoFuente") }))
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
