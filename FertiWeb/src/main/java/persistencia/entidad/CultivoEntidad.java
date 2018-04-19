package persistencia.entidad;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Cultivo")
public class CultivoEntidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	@Column(nullable = false)
	private Date fechaSiembra;
	@Column(nullable = false)
	private Date fechaCosecha;
	@Column(nullable = false)
	private TipoCultivoEntidad tipoCultivo;
	@Column
	private List<AplicacionEntidad> aplicacionFertilizante;
}
