package dominio;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Parcela {

	private Long codigoParcela;
	private Long codigoCultivoSembrado;
	private Long codigoLugar;
	private double area;
	private Date fechaSiembra;

}
