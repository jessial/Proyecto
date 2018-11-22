package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity(name = "Requerimiento")
@Data
@SequenceGenerator(name = "seq_req", sequenceName = "seq_req", initialValue = 10, allocationSize = 1)
public class RequerimientoEntidad {

	@Id
	@Column(name = "req_codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_req")
	private Long codigoRequerimiento;
	@Column(name = "req_codigo_tipo_cultivo", nullable = false)
	private Long codigoTipoCultivo;
	@Column(name = "req_mo")
	private double mo;
	@Column(name = "req_p")
	private double p;
	@Column(name = "req_k")
	private double k;
	@Column(name = "req_mg")
	private double mg;
	@Column(name = "req_ca")
	private double ca;
	@Column(name = "req_al")
	private double al;
	@Column(name = "req_na")
	private double na;
	@Column(name = "req_s")
	private double s;
	@Column(name = "req_fe")
	private double fe;
	@Column(name = "req_b")
	private double b;
	@Column(name = "req_cu")
	private double cu;
	@Column(name = "req_mn")
	private double mn;
	@Column(name = "req_zn")
	private double zn;
	@Column(name = "req_estado", nullable = false)
	private boolean estado;

}
