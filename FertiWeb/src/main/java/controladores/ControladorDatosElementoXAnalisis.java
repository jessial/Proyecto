package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dominio.ElementoXAnalisis;
import dto.DTOElementoXAnalisis;
import persistencia.entidad.ElementoXAnalisisEntidad;
import persistencia.repositorio.ElementoXAnalisisRepository;

public class ControladorDatosElementoXAnalisis extends ControladorDatos {

	@Autowired
	private DozerBeanMapper mapperDozer;
	
	@Autowired
	private ControladorDatosUnidad controladorDatosUnidad;
	
	@Autowired
	private ControladorDatosElemento controladorDatosElemento;

	@Autowired
	private ElementoXAnalisisRepository elementoXAnalisisRepository;
	
	public List<DTOElementoXAnalisis> consultarElementoPorAnalisis(Long codigo) {
		List<ElementoXAnalisis> listElementoXAnalisis = mapearListaADominio(elementoXAnalisisRepository.findBycodigoAnalisis(codigo));
		return construirListaDTO(listElementoXAnalisis);
	}
	
	private List<ElementoXAnalisis> mapearListaADominio(List<ElementoXAnalisisEntidad> elementoXAnalisisEntidadList) {
		return elementoXAnalisisEntidadList.stream().map(a -> mapearADominio(a))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	private List<DTOElementoXAnalisis> construirListaDTO(List<ElementoXAnalisis> listElementoXAnalisis) {
		List<DTOElementoXAnalisis> listDtoElementoXAnalisis = new ArrayList<>();
		for (ElementoXAnalisis elementoXAnalisis : listElementoXAnalisis) {
			listDtoElementoXAnalisis.add(construirDTO(elementoXAnalisis));
		}
		return listDtoElementoXAnalisis;
	}
	
	@Override
	protected DTOElementoXAnalisis construirDTO(Object object) {
		ElementoXAnalisis elementoXAnalisis = (ElementoXAnalisis) object;
		DTOElementoXAnalisis dtoElementoXAnalisis = new DTOElementoXAnalisis();
		dtoElementoXAnalisis.setCantidad(elementoXAnalisis.getCantidad());
		dtoElementoXAnalisis.setCodigoAnalisis(elementoXAnalisis.getCodigoAnalisis());
		dtoElementoXAnalisis.setElemento(controladorDatosElemento.consultarElementosXId(elementoXAnalisis.getCodigoElemento()));
		dtoElementoXAnalisis.setUnidad(controladorDatosUnidad.consultarUnidadXId(elementoXAnalisis.getCodigoUnidad()));
		return dtoElementoXAnalisis;
	}
	
	@Override
	protected ElementoXAnalisis construirDominio(Object object) {
		DTOElementoXAnalisis dtoElementoXAnalisis = (DTOElementoXAnalisis) object;
		ElementoXAnalisis elementoXAnalisis = new ElementoXAnalisis();
		elementoXAnalisis.setCantidad(dtoElementoXAnalisis.getCantidad());
		elementoXAnalisis.setCodigoAnalisis(dtoElementoXAnalisis.getCodigoAnalisis());
		elementoXAnalisis.setCodigoElemento(dtoElementoXAnalisis.getElemento().getCodigoElemento());
		elementoXAnalisis.setCodigoUnidad(dtoElementoXAnalisis.getUnidad().getCodigoUnidad());
		return elementoXAnalisis;
	}
	
	@Override
	protected ElementoXAnalisis mapearADominio(Object object) {
		ElementoXAnalisisEntidad elementoXAnalisisEntidad = (ElementoXAnalisisEntidad) object;
		return mapperDozer.map(elementoXAnalisisEntidad, ElementoXAnalisis.class);
	}

	@Override
	protected ElementoXAnalisisEntidad mapearAEntidad(Object object) {
		ElementoXAnalisis elementoXAnalisis = (ElementoXAnalisis) object;
		return mapperDozer.map(elementoXAnalisis, ElementoXAnalisisEntidad.class);
	}

	@Transactional
	@Override
	public void guardar(Object object) {
		ElementoXAnalisis elementoXAnalisis = (ElementoXAnalisis) object;
		elementoXAnalisisRepository.save(mapearAEntidad(elementoXAnalisis));	
	}
}
