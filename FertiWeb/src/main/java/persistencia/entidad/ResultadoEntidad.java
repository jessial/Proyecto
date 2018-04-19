package persistencia.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Resultado")
public class ResultadoEntidad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	@Column(nullable = false)
	private AnalisisEntidad analisis;
	@Column(nullable = false)
	private UsuarioEntidad usuario;
	@Column(nullable = false)
	private Date fechaAnalisis;
	@Column
	private Double caMg;
	@Column
	private Double caK;
	@Column
	private Double mgK;
	@Column
	private Double caMgK;
	@Column
	private Double satBases;
}
