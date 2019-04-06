package dto;

import java.util.Date;

import dominio.Lugar;
import dominio.TipoCultivo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoParcela {
	
	private Long codigoParcela;
	private Lugar lugar;
	private TipoCultivo tipoCultivo;
	private double area;
	private Date fechaSiembra;
}
