package persistencia.entidad;

import java.util.Date;

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

import dto.AnalisisAdministrador;
import lombok.Data;

@Entity(name = "Analisis")
@SequenceGenerator(name = "seq_analisis", sequenceName = "seq_analisis", initialValue = 10, allocationSize = 1)
@NamedNativeQuery(name = "AnalisisEntidad.getTodos", query = "select a.ana_cantidad as cantidad , a.ana_fecha_analisis as fechaAnalisis, e.elemento as elemento, u.uni_nombre as unidad , l.lug_nombre as lugar from analisis a, elementos e, unidad u, lugar l, parcela p where a.ana_codigo_elemento = e.codigo and ana_codigo_unidad = u.uni_codigo and  p.par_codigo = a.ana_cod_parcela and  p.par_codigo_lugar = l.lug_codigo;", resultSetMapping = "AnalisisAdministrador")
@SqlResultSetMapping(name = "AnalisisAdministrador", classes = @ConstructorResult(targetClass = AnalisisAdministrador.class, columns = {
		@ColumnResult(name = "cantidad", type = Double.class), @ColumnResult(name = "fechaAnalisis"),
		@ColumnResult(name = "elemento"), @ColumnResult(name = "unidad"), @ColumnResult(name = "lugar") }))
@Data
public class AnalisisEntidad {

	@Id
	@Column(name = "ana_codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_analisis")
	private Long codigoAnalisis;
	@Column(name = "ana_cod_parcela")
	private Long codigoParcela;
	@Column(name = "ana_fechaAnalisis")
	private Date fechaAnalisis;
	@Column(name = "ana_codigo_elemento")
	private Long codigoElemento;
	@Column(name = "ana_cantidad")
	private Double cantidad;
	@Column(name = "ana_codigo_unidad")
	private Long codigoUnidad;

}
