package conversores;

import dominio.Elemento;

public class Conversor {
	
	private static final double DENSIDAD_SUELO_POR_PROFUNDIDAD_DE_1_HA = 3.6;
	
	public Double convertirAEquivalentes(Elemento elemento) {
		return elemento.getPesoAtomico() / elemento.getValencia();
	}
	
	public Double convertirAMiniEquivalentes(Double equivalente) {
		return equivalente / 1000;
	}
	
	public Double convertirPorcentajeAPPM(Double porcentajeSaturacion) {
		return porcentajeSaturacion * 10000;
	}
	
	public Double convertirCmolKgAPPM(Double cantidad, Elemento elemento) {
		double miniequivalente = convertirAEquivalentes(elemento);
		double cantidadElemento = cantidad * miniequivalente;
		return cantidadElemento * 10;
	}
	
	public Double convertirPPMAKg(Double ppm) {
		return ppm * DENSIDAD_SUELO_POR_PROFUNDIDAD_DE_1_HA;
	}
	
}
