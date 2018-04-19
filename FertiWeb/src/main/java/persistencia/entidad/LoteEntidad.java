package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Lote")
public class LoteEntidad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	@Column(nullable = false)
	private String ubicacion;
	@Column(nullable = false)
	private int area;
	@Column(nullable = false)
	private UsuarioEntidad usuario;
}
