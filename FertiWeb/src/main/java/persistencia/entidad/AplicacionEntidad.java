package persistencia.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Aplicacion")
public class AplicacionEntidad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	@Column(nullable = false)
	private String producto;
	@Column(nullable = false)
	private Double cantidad;
	@Column(nullable = false)
	private Date fechaAplicacion;
}
