package persistencia.entidad;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "Cultivo")
public class CultivoEntidad {
	
	@Id
	@Column(name="cul_codigo")
	private int codigo;
	@Column(name="cul_fechaSiembra",nullable = false)
	private Date fechaSiembra;
	@Column(name="cul_fechaCosecha",nullable = false)
	private Date fechaCosecha;
	@ManyToOne
	private TipoCultivoEntidad tipoCultivo;
	@OneToMany(mappedBy="codigo")
	private List<AplicacionEntidad> aplicacionFertilizante;
	
	public int getCodigo() {
		return codigo;
	}
	public Date getFechaSiembra() {
		return fechaSiembra;
	}
	public Date getFechaCosecha() {
		return fechaCosecha;
	}
	public TipoCultivoEntidad getTipoCultivo() {
		return tipoCultivo;
	}
	public List<AplicacionEntidad> getAplicacionFertilizante() {
		return aplicacionFertilizante;
	}
	
}
