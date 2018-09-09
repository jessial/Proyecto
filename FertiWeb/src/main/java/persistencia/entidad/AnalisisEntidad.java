package persistencia.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "Analisis")
@Data
public class AnalisisEntidad {
	
	@Id
	@Column(name="ana_codigo")
	private Long codigoAnalisis;
	@Column(name="ana_cod_parcela")
	private Long codigoParcela;
	@Column(name="ana_fechaAnalisis")
	private Date fechaAnalisis;
	@Column(name="ana_base")
	private String base;
	@Column(name="ana_ph")
	private String ph;
	@Column(name="ana_mo")
	private double mo;
	@Column(name="ana_n")
	private double n;
	@Column(name="ana_m")
	private double m;
	@Column(name="ana_k")
	private double k;
	@Column(name="ana_mg")
	private double mg;
	@Column(name="ana_ca")
	private double ca;
	@Column(name="ana_al")
	private double al;
	@Column(name="ana_na")
	private double na;
	@Column(name="ana_s")
	private double s;
	@Column(name="ana_fe")
	private double fe;
	@Column(name="ana_b")
	private double b;
	@Column(name="ana_cu")
	private double cu;
	@Column(name="ana_mn")
	private double mn;
	@Column(name="ana_zn")
	private double zn;
	@Column(name="ana_sana")
	private double saNa;
	@Column(name="ana_sak")
	private double saK;
	@Column(name="ana_saca")
	private double saCa;
	@Column(name="ana_samg")
	private double saMg;
	@Column(name="ana_saal")
	private double saAl;
	@Column(name="ana_porcentajeA")
	private double porcentajeA;
	@Column(name="ana_porcentajeL")
	private double porcentajeL;
	@Column(name="ana_porcentajeAr")
	private double porcentajeAr;
	@Column(name="ana_cice")
	private double cice;
}
