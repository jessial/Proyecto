package persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;

@Entity(name = "Requerimiento")
@Getter
public class RequerimientoEntidad {
	
	@Id
	@Column(name="req_codigo")
	private int codigo;
	@OneToOne(optional=false)
    @JoinColumn(name="tc_codigo", unique=true, nullable=false)
	private TipoCultivoEntidad tipoCultivoEntidad;
	
}
