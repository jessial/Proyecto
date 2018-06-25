package persistencia.entidad;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;

@Entity(name = "Cultivo")
@Getter
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
	
}
