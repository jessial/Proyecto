package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.ElementoXAnalisis;
import dominio.FuenteXRecomendacion;
import dto.DTOElementoXAnalisis;
import dto.DTOFuenteXRecomendacion;
import persistencia.entidad.FuenteXRecomendacionEntidad;
import persistencia.repositorio.FuenteXRecomendacionRepository;

public class ControladorDatosFuenteXRecomendacion extends ControladorDatos {

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private ControladorDatosUnidad controladorDatosUnidad;

	@Autowired
	private FuenteXRecomendacionRepository fuenteXRecomendacionRepository;

	@Autowired
	private ControladorDatosFuente controladorDatosFuente;

	public List<DTOFuenteXRecomendacion> consultarFuentePorRecomendacion(Long codigo) {
		List<FuenteXRecomendacion> listFuenteXRecomendacion = mapearListaADominio(
				fuenteXRecomendacionRepository.findByCodigoRecomendacion(codigo));
		return construirListaDTO(listFuenteXRecomendacion);
	}

	private List<FuenteXRecomendacion> mapearListaADominio(
			List<FuenteXRecomendacionEntidad> fuenteXRecomendacionEntidadList) {
		return fuenteXRecomendacionEntidadList.stream().map(a -> mapearADominio(a))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	private List<DTOFuenteXRecomendacion> construirListaDTO(List<FuenteXRecomendacion> listFuenteXRecomendacion) {
		List<DTOFuenteXRecomendacion> listDtoFuenteXRecomendacion = new ArrayList<>();
		for (FuenteXRecomendacion fuenteXRecomendacion : listFuenteXRecomendacion) {
			listDtoFuenteXRecomendacion.add(construirDTO(fuenteXRecomendacion));
		}
		return listDtoFuenteXRecomendacion;
	}

	@Override
	protected DTOFuenteXRecomendacion construirDTO(Object object) {
		FuenteXRecomendacion fuenteXRecomendacion = (FuenteXRecomendacion) object;
		DTOFuenteXRecomendacion dtoFuenteXRecomendacion = new DTOFuenteXRecomendacion();
		dtoFuenteXRecomendacion.setCodigoFuenteXRecomendacion(fuenteXRecomendacion.getCodigoFuenteXRecomendacion());
		dtoFuenteXRecomendacion.setCantidad(fuenteXRecomendacion.getCantidad());
		dtoFuenteXRecomendacion
				.setUnidad(controladorDatosUnidad.consultarUnidadXId(fuenteXRecomendacion.getCodigoUnidad()));
		dtoFuenteXRecomendacion
				.setFuente(controladorDatosFuente.consultarFuenteXId(fuenteXRecomendacion.getCodigoFuente()));
		dtoFuenteXRecomendacion.setCodigoRecomendacion(fuenteXRecomendacion.getCodigoRecomendacion());

		return dtoFuenteXRecomendacion;
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
	protected FuenteXRecomendacion mapearADominio(Object object) {
		FuenteXRecomendacionEntidad fuenteXRecomendacionEntidad = (FuenteXRecomendacionEntidad) object;
		return mapperDozer.map(fuenteXRecomendacionEntidad, FuenteXRecomendacion.class);
	}

	@Override
	protected FuenteXRecomendacionEntidad mapearAEntidad(Object object) {
		FuenteXRecomendacion fuenteXRecomendacion = (FuenteXRecomendacion) object;
		return mapperDozer.map(fuenteXRecomendacion, FuenteXRecomendacionEntidad.class);
	}

	@Override
	void guardar(Object object) {
		FuenteXRecomendacion fuenteXRecomendacion = (FuenteXRecomendacion) object;
		fuenteXRecomendacionRepository.save(mapearAEntidad(fuenteXRecomendacion));

	}

}
