package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Unidad")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UnidadEntidad {

	@Id
	@Column(name = "uni_codigo")
	private Long codigoUnidad;
	@Column(name = "uni_nombre")
	private String nombreUnidad;

}
