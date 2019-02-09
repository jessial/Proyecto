package persistencia.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity(name = "Analisis")
@SequenceGenerator(name = "seq_analisis", sequenceName = "seq_analisis", initialValue = 10, allocationSize = 1)
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
