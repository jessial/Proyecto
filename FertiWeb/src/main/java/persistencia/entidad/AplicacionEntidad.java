package persistencia.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;

@Entity(name = "Aplicacion")
@Getter 
public class AplicacionEntidad {

	@Id
	@Column(name="apli_codigo")
	private int codigo;
	@Column(name="apli_producto",nullable = false)
	private String producto;
	@Column(name="apli_cantidad",nullable = false)
	private Double cantidad;
	@Column(name="apli_fechaAplicacion",nullable = false)
	private Date fechaAplicacion;
	
}
