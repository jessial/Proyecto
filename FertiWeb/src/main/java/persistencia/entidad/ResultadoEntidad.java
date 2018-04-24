package persistencia.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Resultado")
public class ResultadoEntidad {

	@Id
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
	
	public int getCodigo() {
		return codigo;
	}
	public AnalisisEntidad getAnalisis() {
		return analisis;
	}
	public UsuarioEntidad getUsuario() {
		return usuario;
	}
	public Date getFechaAnalisis() {
		return fechaAnalisis;
	}
	public Double getCaMg() {
		return caMg;
	}
	public Double getCaK() {
		return caK;
	}
	public Double getMgK() {
		return mgK;
	}
	public Double getCaMgK() {
		return caMgK;
	}
	public Double getSatBases() {
		return satBases;
	}
}
