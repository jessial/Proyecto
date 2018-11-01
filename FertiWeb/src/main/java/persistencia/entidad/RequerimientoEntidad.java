package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "Requerimiento")
@Data
public class RequerimientoEntidad {
	
	@Id
	@Column(name="req_codigo_cultivo_sembrado")
	private Long codigoCultivoSembrado;
	@Column(name="req_codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
	private Long codigoRequerimiento;
	@Column(name="req_nutriente",nullable = false)
	private String nutriente;
	@Column(name="req_cantidad",nullable = false)
	private Double candtidad;
	@Column(name ="req_estado",nullable = false)
	private boolean estado;

}
