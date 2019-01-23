package persistencia.entidad;

import java.io.Serializable;

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

import dto.RequerimientoPorCultivo;
import lombok.Data;

@Entity(name = "Requerimiento")
@Data
@SequenceGenerator(name = "seq_req", sequenceName = "seq_req", initialValue = 10, allocationSize = 1)
@NamedNativeQuery(name = "RequerimientoEntidad.getTodos", query = "select \r\n"
		+ "r.req_codigo as codigoRequerimiento ,\r\n" + " r.req_cantidad as cantidad,\r\n"
		+ " tc.cul_nombre as cultivo,\r\n" + "tc.cul_variedad as variedad,\r\n" + " r.req_estado as estado,\r\n"
		+ " e.elemento as elemento,\r\n" + " u.uni_nombre as unidad\r\n"
		+ " from requerimiento r, tipo_cultivo tc, elementos e, unidad u where r.req_codigo_tipo_cultivo = tc.cul_codigo and r.req_elemento = e.codigo and r.uni_codigo = u.uni_codigo", resultSetMapping = "RequerimientoPorCultivo")
@SqlResultSetMapping(name = "RequerimientoPorCultivo", classes = @ConstructorResult(targetClass = RequerimientoPorCultivo.class, columns = {
		@ColumnResult(name = "codigoRequerimiento", type = Long.class), @ColumnResult(name = "cantidad"),
		@ColumnResult(name = "cultivo"), @ColumnResult(name = "variedad"), @ColumnResult(name = "estado"),
		@ColumnResult(name = "elemento"), @ColumnResult(name = "unidad") }))

public class RequerimientoEntidad implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "req_codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_req")
	private Long codigoRequerimiento;
	@Column(name = "req_codigo_tipo_cultivo", nullable = false)
	private Long codigoTipoCultivo;
	@Column(name = "req_elemento")
	private Long reqCodigoElemento;
	@Column(name = "req_estado", nullable = false)
	private boolean estado;
	@Column(name = "req_cantidad", nullable = false)
	private double cantidad;
	@Column(name = "uni_codigo")
	private Long uniCodigo;

}
