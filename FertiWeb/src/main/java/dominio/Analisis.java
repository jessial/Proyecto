package dominio;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Analisis {

	private Long codigoAnalisis;
	private Parcela parcela;
	private Date fechaAnalisis;
	private List<ElementoXAnalisis> elementos;
}
