package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "Parcela")
@Data
public class ParcelaEntidad {

	@Id
	@Column(name="par_codigo")
	private Long codigoParcela;
	@Column(name="par_codigo_cultivo_sembrado")
	private Long codigoCultivoSembrado;
	@Column(name="par_codigo_lugar")
	private Long codigoLugar;
	@Column(name="par_ubicacion",nullable = false)
	private String ubicacion;
	@Column(name="par_area" ,nullable = false)
	private int area;
}
