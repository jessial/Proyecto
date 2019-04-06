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
	private Lugar lugar;
	private TipoCultivo tipoCultivo;
	private double area;
	private Date fechaSiembra;

	private Long codigoCultivoSembrado;
	private Long codigoLugar;

	public Parcela(Long codigoParcela, Lugar lugar, TipoCultivo tipoCultivo, double area, Date fechaSiembra) {
		this.codigoParcela = codigoParcela;
		this.lugar = lugar;
		this.tipoCultivo = tipoCultivo;
		this.area = area;
		this.fechaSiembra = fechaSiembra;
	}

}
