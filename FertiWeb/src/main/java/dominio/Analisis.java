package dominio;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Analisis {

	private Long codigoAnalisis;
	private Date fechaAnalisis;
	private Long codigoParcela;

}
