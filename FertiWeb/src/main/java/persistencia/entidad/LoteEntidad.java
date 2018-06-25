package persistencia.entidad;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;

@Entity(name = "Lote")
@Getter
public class LoteEntidad {

	@Id
	@Column(name="lot_codigo")
	private int codigo;
	@Column(name="lot_ubicacion",nullable = false)
	private String ubicacion;
	@Column(name="lot_area" ,nullable = false)
	private int area;
	@OneToMany(mappedBy="cedula")
	private List<UsuarioEntidad> usuarioEntidad;
	@OneToMany(mappedBy="codigo")
	private List<AnalisisEntidad> analilsisEntidad;
	
}
