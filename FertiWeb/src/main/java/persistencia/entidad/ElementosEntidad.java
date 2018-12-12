package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "Elementos")
@Data
public class ElementosEntidad {

	@Id
	@Column(name = "codigo")
	private Long codigoElemento;
	@Column(name = "elemento")
	private String elemento;

}
