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

@Entity(name = "FuenteXRecomendacion")
@SequenceGenerator(name = "seq_fuenteXrecomendacion", sequenceName = "seq_fuenteXrecomendacion", initialValue = 10, allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FuenteXRecomendacionEntidad {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fuenteXrecomendacion")
	@Column(name = "fuxrec_codigo_fuente_recomendacion")
	private Long codigoFuenteXRecomendacion;
	@Column(name = "fuxrec_codigo_fuente")
	private Long codigoFuente;
	@Column(name = "fuxrec_cantidad")
	private Double cantidad;
	@Column(name = "fuxrec_codigo_unidad")
	private Long codigoUnidad;
	@Column(name = "fuxrec_codigo_recomendacion")
	private Long codigoRecomendacion;

}
