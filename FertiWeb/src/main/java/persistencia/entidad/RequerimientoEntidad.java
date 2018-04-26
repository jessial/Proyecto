package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import dominio.TipoCultivo;

@Entity(name = "Requerimiento")
public class RequerimientoEntidad {
	
	@Id
	@Column(name="req_codigo")
	private int codigo;
	@OneToOne(optional=false)
    @JoinColumn(name="tc_codigo", unique=true, nullable=false)
	private TipoCultivoEntidad tipoCultivoEntidad;
	
	public int getCodigo() {
		return codigo;
	}
	public TipoCultivoEntidad getTipoCultivo() {
		return tipoCultivoEntidad;
	}
	
}
