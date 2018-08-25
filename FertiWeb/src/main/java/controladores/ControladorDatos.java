package controladores;

import org.dozer.DozerBeanMapper;

import org.springframework.beans.factory.annotation.Autowired;

import dominio.Analisis;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import persistencia.entidad.AnalisisEntidad;
import persistencia.repositorio.AnalisisRepository;

@AllArgsConstructor
@NoArgsConstructor
public class ControladorDatos {
	
	@Autowired
	private DozerBeanMapper mapperDozer;
	
	@Autowired
	private AnalisisRepository analisisRepository;

	public void guardarAnalisis(Analisis analisisSuelo) {
		AnalisisEntidad analisisEntidad = new AnalisisEntidad();
		mapperDozer.map(analisisSuelo, analisisEntidad);
		analisisRepository.save(analisisEntidad);
	}
	
}
