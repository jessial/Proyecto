package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import dto.DTOElementoXAnalisis;
import persistencia.entidad.ElementoXAnalisisEntidad;
import persistencia.repositorio.ElementoXAnalisisRepository;

public class ControladorDatosElementoXAnalisis {

/*	@Autowired
	private DozerBeanMapper mapperDozer;*/
	
	@Autowired
	private ControladorDatosUnidad controladorDatosUnidad;
	
	@Autowired
	private ControladorDatosElemento controladorDatosElemento;

	@Autowired
	private ElementoXAnalisisRepository elementoXAnalisisRepository;
	
	public List<DTOElementoXAnalisis> consultarElementoPorAnalisis(Long codigo) {
		return mapearElementoXAnalisis(elementoXAnalisisRepository.findBycodigoAnalisis(codigo));
	}
	
	private List<DTOElementoXAnalisis> mapearElementoXAnalisis(List<ElementoXAnalisisEntidad> elementoXAnalisisEntidadList) {
		return elementoXAnalisisEntidadList.stream().map(a -> construirElemento(a))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	private DTOElementoXAnalisis construirElemento(ElementoXAnalisisEntidad elementoXAnalisisEntidad) {
		DTOElementoXAnalisis dtoElementoXAnalisis = new DTOElementoXAnalisis();
		dtoElementoXAnalisis.setCantidad(elementoXAnalisisEntidad.getCantidad());
		dtoElementoXAnalisis.setCodigoAnalisis(elementoXAnalisisEntidad.getCodigoAnalisis());
		dtoElementoXAnalisis.setElemento(controladorDatosElemento.consultarElementosXId(elementoXAnalisisEntidad.getCodigoElemento()));
		dtoElementoXAnalisis.setUnidad(controladorDatosUnidad.consultarUnidadXId(elementoXAnalisisEntidad.getCodigoUnidad()));
		return dtoElementoXAnalisis;
	}
}
