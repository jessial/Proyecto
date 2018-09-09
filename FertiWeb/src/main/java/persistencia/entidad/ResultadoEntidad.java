package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "Resultado")
@Data
public class ResultadoEntidad {

	@Id
	@Column(name="res_codigo")
	private Long codigoResultado;
	@Column(name="res_codigo_parcela")
	private Long codigoParcela;
	@Column(name="res_camg")
	private Double caMg;
	@Column(name="res_cak")
	private Double caK;
	@Column(name="res_mgk")
	private Double mgK;
	@Column(name="res_camgk")
	private Double caMgK;
	@Column(name="res_satbases")
	private Double satBases;
	
}
