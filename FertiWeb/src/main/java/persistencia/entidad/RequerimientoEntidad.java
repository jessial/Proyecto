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
@SequenceGenerator(name="seq_req", sequenceName="seq_req", initialValue=10, allocationSize = 1)
public class RequerimientoEntidad {
	
	@Id
	@Column(name="req_codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_req")
	private Long codigoRequerimiento;
	@Column(name="req_codigo_cultivo_sembrado",nullable = false)
	private Long reqCodigoCultivoSembrado;
	@Column(name="req_nutriente",nullable = false)
	private String nutriente;
	@Column(name="req_cantidad",nullable = false)
	private double candtidad;
	@Column(name ="req_estado",nullable = false)
	private boolean estado;

}
