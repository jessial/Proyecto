package persistencia.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Analisis")
public class AnalisisEntidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
}
