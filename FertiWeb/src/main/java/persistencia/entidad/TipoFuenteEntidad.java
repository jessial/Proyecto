package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "TipoFuente")
@Data
public class TipoFuenteEntidad {
	
	@Id
	@Column(name="tf_codigo")
	private int codigo;
	@Column(name="tf_nombre",nullable = false)
	private String nombre;
	@Column(name="tf_aporte",nullable = false)
	private double aporte;
	@Column(name = "tf_estado",nullable = false)
	private boolean estado;
	
}
