package dto;

import java.util.Date;

import lombok.Value;

@Value
public class AnalisisAdministrador {

	private Double cantidad;
	private Date fechaAnalisis;
	private String elemento;
	private String unidad;
	private String lugar;

}
