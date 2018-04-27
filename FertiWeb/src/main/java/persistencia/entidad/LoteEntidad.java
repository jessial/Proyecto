package persistencia.entidad;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "Lote")
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
	
	public int getCodigo() {
		return codigo;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public int getArea() {
		return area;
	}
	public List<UsuarioEntidad> getUsuarioEntidad() {
		return usuarioEntidad;
	}
}
