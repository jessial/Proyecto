package persistencia.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity(name = "Parcela")
@SequenceGenerator(name = "seq_parcela", sequenceName = "seq_parcela", initialValue = 10, allocationSize = 1)
@Data
public class ParcelaEntidad {

	@Id
	@Column(name = "par_codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_parcela")
	private Long codigoParcela;
	@Column(name = "par_codigo_cultivo_sembrado")
	private Long codigoCultivoSembrado;
	@Column(name = "par_codigo_lugar")
	private Long codigoLugar;
	@Column(name = "par_area", nullable = false)
	private double area;
	@Column(name = "par_fecha_posible_siembra")
	private Date fechaPosibleSiembra;
}
