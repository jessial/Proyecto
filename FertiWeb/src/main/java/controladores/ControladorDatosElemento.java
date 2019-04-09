package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.Elemento;
import persistencia.entidad.ElementosEntidad;
import persistencia.repositorio.ElementosRepository;

public class ControladorDatosElemento extends ControladorDatos{

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private ElementosRepository elementoRepository;

	public List<Elemento> consultarElementos() {
		return mapearListaADominio(elementoRepository.findAll());
	}

	public ElementosEntidad consultarElementosPorId(Long id) {
		ElementosEntidad elementosEntidad = new ElementosEntidad();
		mapperDozer.map(elementoRepository.findByCodigoElemento(id), elementosEntidad);
		return elementosEntidad;
	}

	public Elemento consultarElementosXId(Long codigoElemento) {
		return mapearADominio(elementoRepository.findByCodigoElemento(codigoElemento));
	}
	
	private List<Elemento> mapearListaADominio(List<ElementosEntidad> listElementosEntidad) {
		return listElementosEntidad.stream().map(a -> mapearADominio(a))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	protected Object construirDTO(Object object) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	protected Object construirDominio(Object object) {
		throw new UnsupportedOperationException();
	}

	@Override
	protected Elemento mapearADominio(Object object) {
		ElementosEntidad elementoEntidad = (ElementosEntidad) object;
		return mapperDozer.map(elementoEntidad, Elemento.class);
	}

	@Override
	protected ElementosEntidad mapearAEntidad(Object object) {
		Elemento analisis = (Elemento) object;
		return mapperDozer.map(analisis, ElementosEntidad.class);
	}

	@Override
	void guardar(Object object) {
		throw new UnsupportedOperationException();
	}

}
