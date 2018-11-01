package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity(name = "Cultivo_Sembrado")
@Data
@SequenceGenerator(name="seq", sequenceName="seq_cultivo", initialValue=10, allocationSize = 1)
public class CultivoSembradoEntidad {
	
	@Id
	@Column(name="cul_codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
	private Long codigoCultivoSembrado;
	@Column(name="cul_nombre",nullable = false)
	private String nombre;
	@Column(name="cul_variedad",nullable = false)
	private String variedad;
	@Column(name="cul_estado",nullable = false)
	private boolean estado;
	
}