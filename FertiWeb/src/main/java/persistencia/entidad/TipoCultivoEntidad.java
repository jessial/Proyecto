package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "TipoCultivo")
public class TipoCultivoEntidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	@Column(nullable = false)
	private String variedad;
	@Column(nullable = false)
	private String nombre;

}
