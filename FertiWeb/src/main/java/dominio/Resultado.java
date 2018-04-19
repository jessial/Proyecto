package dominio;

import java.util.Date;

public class Resultado {
	
	private int codigo;
	private Analisis analisis;
	private Usuario usuario;
	private Date fechaAnalisis;
	private Double caMg;
	private Double caK;
	private Double mgK;
	private Double caMgK;
	private Double satBases;
	
	public int getCodigo() {
		return codigo;
	}
	public Analisis getAnalisis() {
		return analisis;
	}
	public Usuario getUsuario() {
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
