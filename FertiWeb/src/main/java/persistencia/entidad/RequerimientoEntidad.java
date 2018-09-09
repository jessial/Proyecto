package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "Requerimiento")
@Data
public class RequerimientoEntidad {
	
	@Id
	@Column(name="req_codigo_cultivo_sembrado")
	private Long codigoCultivoSembrado;
	@Column(name="req_codigo")
	private Long codigoRequerimiento;
	@Column(name="req_nutriente")
	private String nutriente;
	@Column(name="req_cantidad")
	private Double candtidad;

}
