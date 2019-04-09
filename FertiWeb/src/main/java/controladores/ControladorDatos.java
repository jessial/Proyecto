package controladores;

public abstract class ControladorDatos {
	
	protected abstract Object construirDTO(Object object);
	
	protected abstract Object mapearADominio(Object object);
	
	protected abstract Object mapearAEntidad(Object object);
	
	abstract void guardar(Object object);

}
