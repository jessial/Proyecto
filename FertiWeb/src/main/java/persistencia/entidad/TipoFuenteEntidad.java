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

import dto.TipoFuentePorUnidad;
import lombok.Data;

@Entity(name = "TipoFuente")
@Data
@SequenceGenerator(name = "seq_tf", sequenceName = "seq_tf", initialValue = 10, allocationSize = 1)
@NamedNativeQuery(name = "TipoFuenteEntidad.getTodos", query = "select f.tf_codigo as codigoTipoFuente, f.tf_aporte as aporte, f.tf_estado as estado, f.tf_nombre as tipoFuente, u.uni_codigo as codigoUnidad, u.uni_nombre as unidad from tipo_fuente f, unidad u where u.uni_codigo = f.tf_unidad;", resultSetMapping = "TipoFuenteporUnidad")
@SqlResultSetMapping(name = "TipoFuenteporUnidad", classes = @ConstructorResult(targetClass = TipoFuentePorUnidad.class, columns = {
		@ColumnResult(name = "codigoTipoFuente", type = Long.class), @ColumnResult(name = "aporte"),
		@ColumnResult(name = "estado"), @ColumnResult(name = "tipoFuente"),
		@ColumnResult(name = "codigoUnidad", type = Long.class), @ColumnResult(name = "unidad") }))
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
