package persistencia.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;

@Entity(name = "Analisis")
@Getter 
public class AnalisisEntidad {
	
	@Id
	@Column(name="ana_codigo")
	private int codigo;
	@Column(name="ana_fechaAnalisis",nullable = false)
	private Date fechaAnalisis;
	@OneToOne
	private ResultadoEntidad resultado;
	@Column(name="ana_ph")
	private Double ph;
	@Column(name="ana_mo")
	private Double mo;
	@Column(name="ana_n")
	private Double n;
	@Column(name="ana_m")
	private Double m;
	@Column(name="ana_k")
	private Double k;
	@Column(name="ana_mg")
	private Double mg;
	@Column(name="ana_ca")
	private Double ca;
	@Column(name="ana_al")
	private Double al;
	@Column(name="ana_na")
	private Double na;
	@Column(name="ana_s")
	private Double s;
	@Column(name="ana_fe")
	private Double fe;
	@Column(name="ana_b")
	private Double b;
	@Column(name="ana_cu")
	private Double cu;
	@Column(name="ana_mn")
	private Double mn;
	@Column(name="ana_zn")
	private Double zn;
	@Column(name="ana_sana")
	private Double saNa;
	@Column(name="ana_sak")
	private Double saK;
	@Column(name="ana_saca")
	private Double saCa;
	@Column(name="ana_samg")
	private Double saMg;
	@Column(name="ana_saal")
	private Double saAl;
	
}
