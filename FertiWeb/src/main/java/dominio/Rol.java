package dominio;

public class Rol {

	private Long codigo;
	private String nombre;
	private boolean estado;

	public Rol(Long codigo, String nombre, boolean estado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.estado = estado;
	}

	public Rol() {
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
