package persistencia.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Analisis")
public class AnalisisEntidad {
	
	@Id
	private int codigo;
	@Column(nullable = false)
	private LoteEntidad lote;
	@Column(nullable = false)
	private UsuarioEntidad usuario;
	@Column(nullable = false)
	private Date fechaAnalisis;
	@Column
	private Double ph;
	@Column
	private Double mo;
	@Column
	private Double n;
	@Column
	private Double m;
	@Column
	private Double k;
	@Column
	private Double mg;
	@Column
	private Double ca;
	@Column
	private Double al;
	@Column
	private Double na;
	@Column
	private Double s;
	@Column
	private Double fe;
	@Column
	private Double b;
	@Column
	private Double cu;
	@Column
	private Double mn;
	@Column
	private Double zn;
	@Column
	private Double saNa;
	@Column
	private Double saK;
	@Column
	private Double saCa;
	@Column
	private Double saMg;
	@Column
	private Double saAl;
	public int getCodigo() {
		return codigo;
	}
	public LoteEntidad getLote() {
		return lote;
	}
	public UsuarioEntidad getUsuario() {
		return usuario;
	}
	public Date getFechaAnalisis() {
		return fechaAnalisis;
	}
	public Double getPh() {
		return ph;
	}
	public Double getMo() {
		return mo;
	}
	public Double getN() {
		return n;
	}
	public Double getM() {
		return m;
	}
	public Double getK() {
		return k;
	}
	public Double getMg() {
		return mg;
	}
	public Double getCa() {
		return ca;
	}
	public Double getAl() {
		return al;
	}
	public Double getNa() {
		return na;
	}
	public Double getS() {
		return s;
	}
	public Double getFe() {
		return fe;
	}
	public Double getB() {
		return b;
	}
	public Double getCu() {
		return cu;
	}
	public Double getMn() {
		return mn;
	}
	public Double getZn() {
		return zn;
	}
	public Double getSaNa() {
		return saNa;
	}
	public Double getSaK() {
		return saK;
	}
	public Double getSaCa() {
		return saCa;
	}
	public Double getSaMg() {
		return saMg;
	}
	public Double getSaAl() {
		return saAl;
	}
	
	
}
