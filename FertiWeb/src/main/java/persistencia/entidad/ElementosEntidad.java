package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Elementos")
public class ElementosEntidad {

	@Id
	@Column(name = "codigo")
	private Long codigoElemento;
	@Column(name = "elemento")
	private String elemento;

}
