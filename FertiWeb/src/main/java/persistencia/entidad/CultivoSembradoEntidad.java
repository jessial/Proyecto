package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "Cultivo_Sembrado")
@Data
public class CultivoSembradoEntidad {
	
	@Id
	@Column(name="cul_codigo")
	private Long codigoCultivoSembrado;
	@Column(name="cul_nombre",nullable = false)
	private String nombre;
	@Column(name="cul_variedad",nullable = false)
	private String variedad;
	@Column(name="cul_estado",nullable = false)
	private boolean estado;
	
}
