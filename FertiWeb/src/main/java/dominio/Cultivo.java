package dominio;

import java.util.Date;
import java.util.List;

public class Cultivo {

	private int codigo;
	private Date fechaSiembra;
	private Date fechaCosecha;
	private TipoCultivo tipoCultivo;
	private List<Aplicacion> aplicacionFertilizante;

	public int getCodigo() {
		return codigo;
	}

	public Date getFechaSiembra() {
		return fechaSiembra;
	}

	public Date getFechaCosecha() {
		return fechaCosecha;
	}

	public TipoCultivo getTipoCultivo() {
		return tipoCultivo;
	}

	public List<Aplicacion> getAplicacionFertilizante() {
		return aplicacionFertilizante;
	}
}
