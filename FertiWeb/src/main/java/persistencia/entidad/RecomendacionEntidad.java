package persistencia.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Recomendacion")
@SequenceGenerator(name = "seq_recomendacion", sequenceName = "seq_recomendacion", initialValue = 10, allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecomendacionEntidad {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_recomendacion")
	@Column(name = "rec_codigo_recomendacion")
	private Long codigoRecomendacion;
	@Column(name = "rec_codigo_analisis")
	private Long codigoAnalisis;
	@Column(name = "rec_fecha_recomendacion")
	private Date fechaRecomendacion;

}
