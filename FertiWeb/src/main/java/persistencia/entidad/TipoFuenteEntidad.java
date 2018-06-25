package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;

@Entity(name = "TipoFuente")
@Getter
public class TipoFuenteEntidad {
	
	@Id
	@Column(name="tf_codigo")
	private int codigo;
	@Column(name="tf_nombre",nullable = false)
	private String nombre;
	@Column(name="tf_aporte",nullable = false)
	private double aporte;
	
}
