package persistencia.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;

@Entity(name = "Resultado")
@Getter
public class ResultadoEntidad {

	@Id
	@Column(name="res_codigo")
	private int codigo;
	@Column(name="res_fechaAnalisis",nullable = false)
	private Date fechaAnalisis;
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
