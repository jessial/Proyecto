package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.ElementoXAnalisis;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import persistencia.entidad.ElementoXAnalisisEntidad;
import persistencia.repositorio.ElementoXAnalisisRepository;

@AllArgsConstructor
@NoArgsConstructor
public class ControladorDatosElementoXAnalisis {

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private ElementoXAnalisisRepository elementoXAnalisisRepository;
	
	public List<ElementoXAnalisis> consultarElementoPorAnalisis(Long codigo) {
		return mapearElementoXAnalisis(elementoXAnalisisRepository.findBycodigoAnalisis(codigo));
	}
	
	private List<ElementoXAnalisis> mapearElementoXAnalisis(List<ElementoXAnalisisEntidad> elementoXAnalisisEntidadList) {
		return elementoXAnalisisEntidadList.stream().map(a -> mapperDozer.map(a, ElementoXAnalisis.class))
				.collect(Collectors.toCollection(ArrayList::new));
	}
}
