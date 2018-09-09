package dto;

import java.util.List;

import dominio.Analisis;
import dominio.CultivoSembrado;
import dominio.Lugar;
import dominio.Parcela;
import dominio.Resultado;
import dominio.Rol;
import dominio.Usuario;
import lombok.Data;

@Data
public class DtoResponse {
	
	private Usuario usuario;
	private Rol rolUsuario;
	private List<Rol> roles;
	private List<Lugar> lugares;
	private List<Parcela> parcelas;
	private List<Resultado> resultados;
	private List<Analisis> analisis;
	private List<CultivoSembrado> cultivos;
	
	
}
