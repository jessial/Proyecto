package dto;

import java.util.Date;

import dominio.TipoCultivo;
import lombok.Data;

@Data
public class DTOParcela {
	
	private Long codigoParcela;
	private DTOLugar lugar;
	private TipoCultivo tipoCultivo;
	private double area;
	private Date fechaSiembra;
}
