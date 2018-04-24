package persistencia.entidad;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Cultivo")
public class CultivoEntidad {
	
	@Id
	private int codigo;
	@Column(nullable = false)
	private Date fechaSiembra;
	@Column(nullable = false)
	private Date fechaCosecha;
	@Column(nullable = false)
	private TipoCultivoEntidad tipoCultivo;
	@Column
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
