package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "ElementoXAnalisis")
@SequenceGenerator(name = "seq_elementoXanalisis", sequenceName = "seq_elementoXanalisis", initialValue = 10, allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ElementoXAnalisisEntidad {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_analisis")
	@Column(name = "exa_codigo")
	private Long elementoXAnalisisCodigo;
	@Column(name = "ana_codigo")
	private Long codigoAnalisis;
	@Column(name = "aexa_elemento")
	private Long codigoElemento;
	@Column(name = "exa_cantidad")
	private Double cantidad;
	@Column(name = "exa_unidad")
	private Long codigoUnidad;
}
