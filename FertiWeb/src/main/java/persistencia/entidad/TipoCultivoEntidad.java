package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Tipo_Cultivo")
@SequenceGenerator(name = "seq", sequenceName = "seq_cultivo", initialValue = 10, allocationSize = 1)
public class TipoCultivoEntidad {

	@Id
	@Column(name = "cul_codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private Long codigoTipoCultivo;
	@Column(name = "cul_nombre", nullable = false)
	private String nombre;
	@Column(name = "cul_variedad", nullable = false)
	private String variedad;
	@Column(name = "cul_estado", nullable = false)
	private boolean estado;

}
