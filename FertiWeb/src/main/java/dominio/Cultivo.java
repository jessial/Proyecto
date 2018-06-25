package dominio;

import java.util.Date;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;

@Getter (AccessLevel.PRIVATE)
public class Cultivo {

	private int codigo;
	private Date fechaSiembra;
	private Date fechaCosecha;
	private TipoCultivo tipoCultivo;
	private List<Aplicacion> aplicacionFertilizante;

}
