package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "Recomendacion")
@Data
public class RecomendacionEntidad {
	
	@Id
	@Column(name="rec_codigo")
	private Long codigoRequerimiento;
	@Column(name="rec_codigo_parcela")
	private Long codigoAnalisis;
	@Column(name="rec_codigoFuente")
	private Long codigoFuente;
	@Column(name="rec_cantidad")
	private Double cantidad;
	@Column(name="rec_Unidad")
	private Long codigoUnidad;
	
}
