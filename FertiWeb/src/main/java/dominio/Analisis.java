package dominio;

import java.util.Date;

import lombok.AccessLevel;
import lombok.Getter;

@Getter (AccessLevel.PRIVATE)
public class Analisis {

	private int codigo;
	private Lote lote;
	private Usuario usuario;
	private Date fechaAnalisis;
	private Double ph;
	private Double mo;
	private Double n;
	private Double m;
	private Double k;
	private Double mg;
	private Double ca;
	private Double al;
	private Double na;
	private Double s;
	private Double fe;
	private Double b;
	private Double cu;
	private Double mn;
	private Double zn;
	private Double saNa;
	private Double saK;
	private Double saCa;
	private Double saMg;
	private Double saAl;
	
	
}
