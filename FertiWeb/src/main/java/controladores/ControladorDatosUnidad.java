package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.Unidad;
import persistencia.entidad.UnidadEntidad;
import persistencia.repositorio.UnidadRepository;

public class ControladorDatosUnidad extends ControladorDatos{

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private UnidadRepository unidadRepository;

	public List<Unidad> consultarUnidad() {
		return mapearListaADominio(unidadRepository.findAll());
	}

	public Unidad consultarUnidadXId(Long unidad) {
		return mapearADominio(unidadRepository.findByCodigoUnidad(unidad));
	}
	
	private List<Unidad> mapearListaADominio(List<UnidadEntidad> unidadEntidadList) {
		return unidadEntidadList.stream().map(a -> mapearADominio(a))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	protected Unidad construirDTO(Object object) {
		throw new UnsupportedOperationException();
	}
	
	protected Unidad construirDominio(Object object) {
		throw new UnsupportedOperationException();
	}

	@Override
	protected Unidad mapearADominio(Object object) {
		UnidadEntidad unidadEntidad = (UnidadEntidad) object;
		return mapperDozer.map(unidadEntidad, Unidad.class);
	}

	@Override
	protected UnidadEntidad mapearAEntidad(Object object) {
		Unidad unidad = (Unidad) object;
		return mapperDozer.map(unidad, UnidadEntidad.class);
	}

	@Override
	void guardar(Object object) {
		throw new UnsupportedOperationException();
	}

	public UnidadEntidad consultarUnidadPorId(Long uniCodigo) {
		return unidadRepository.findByCodigoUnidad(uniCodigo);
	}

}
