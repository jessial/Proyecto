package dominio;

import java.util.Date;

import lombok.AccessLevel;
import lombok.Getter;

@Getter (AccessLevel.PRIVATE)
public class Aplicacion {
	
	private int codigo;
	private String producto;
	private Double cantidad;
	private Date fechaAplicacion;
	
}
