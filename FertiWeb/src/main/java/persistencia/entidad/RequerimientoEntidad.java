package persistencia.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Requerimiento")
@SequenceGenerator(name = "seq_req", sequenceName = "seq_req", initialValue = 10, allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequerimientoEntidad implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "req_codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_req")
	private Long codigoRequerimiento;
	@Column(name = "req_codigo_tipo_cultivo", nullable = false)
	private Long codigoTipoCultivo;
	@Column(name = "req_elemento")
	private Long reqCodigoElemento;
	@Column(name = "req_estado", nullable = false)
	private boolean estado;
	@Column(name = "req_cantidad", nullable = false)
	private double cantidad;
	@Column(name = "uni_codigo")
	private Long uniCodigo;

}
