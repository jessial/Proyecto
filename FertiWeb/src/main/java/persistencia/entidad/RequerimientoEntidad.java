package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import dominio.TipoCultivo;

@Entity(name = "Requerimiento")
public class RequerimientoEntidad {
	
	@Id
	private int codigo;
	@Column(nullable = false)
	private TipoCultivo tipoCultivo;
	
	public int getCodigo() {
		return codigo;
	}
	public TipoCultivo getTipoCultivo() {
		return tipoCultivo;
	}
	
}
