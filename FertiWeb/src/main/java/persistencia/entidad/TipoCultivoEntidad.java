package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "TipoCultivo")
@Data
public class TipoCultivoEntidad {
	
	@Id
	@GeneratedValue
	@Column(name="tc_codigo")
	private Long codigo;
	@Column(name="tc_variedad",nullable = false)
	private String variedad;
	@Column(name="tc_nombre",nullable = false)
	private String nombre;
	@Column(name="tc_estado",nullable = false)
	private boolean estado;
	
}
