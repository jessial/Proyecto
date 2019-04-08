package dto;

import java.util.Date;

import dominio.Lugar;
import dominio.TipoCultivo;
import lombok.Data;

@Data
public class DTOParcela {
	
	private Long codigoParcela;
	private Lugar lugar;
	private TipoCultivo tipoCultivo;
	private double area;
	private Date fechaSiembra;
}
