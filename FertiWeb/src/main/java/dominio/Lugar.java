package dominio;

public class Lugar {

	private Long codigoLugar;
	private String nombre;
	private Usuario usuario;
	private String ubicacion;

	public Lugar(Long codigoLugar, String nombre, Usuario usuario, String ubicacion) {
		this.codigoLugar = codigoLugar;
		this.nombre = nombre;
		this.usuario = usuario;
		this.ubicacion = ubicacion;
	}

	public Lugar() {
	}

	public Long getCodigoLugar() {
		return codigoLugar;
	}

	public String getNombre() {
		return nombre;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public String getUbicacion() {
		return ubicacion;
	}

}
