package dto;

import java.util.List;

import dominio.Analisis;
import dominio.Lugar;
import dominio.Parcela;
import dominio.Recomendacion;
import dominio.Requerimiento;
import dominio.Resultado;
import dominio.Rol;
import dominio.TipoCultivo;
import dominio.TipoFuente;
import dominio.Usuario;
import lombok.Data;

@Data
public class DTOResponse {
	
	private Usuario usuario;
	private Rol rolUsuario;
	private List<Rol> roles;
	private List<Lugar> lugares;
	private List<Parcela> parcelas;
	private List<Resultado> resultados;
	private List<Analisis> analisis;
	private List<TipoCultivo> cultivos;
	private List<Recomendacion> recomendaciones;
	private Requerimiento requerimientoCultivo;
	private List<Requerimiento> requerimientos;
	private TipoFuente tipoFuente;
	private List<TipoFuente> tiposFuente;
		
}
