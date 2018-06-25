package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;

@Entity(name = "TipoCultivo")
@Getter
public class TipoCultivoEntidad {
	
	@Id
	@Column(name="tc_codigo")
	private int codigo;
	@Column(name="tc_variedad",nullable = false)
	private String variedad;
	@Column(name="tc_nombre",nullable = false)
	private String nombre;
	
}
