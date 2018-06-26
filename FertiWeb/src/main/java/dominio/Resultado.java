package dominio;

import java.util.Date;

import lombok.AccessLevel;
import lombok.Getter;

@Getter (AccessLevel.PRIVATE)
public class Resultado {
	
	private int codigo;
	private Analisis analisis;
	private Usuario usuario;
	private Date fechaAnalisis;
	private Double caMg;
	private Double caK;
	private Double mgK;
	private Double caMgK;
	private Double satBases;
	
}
