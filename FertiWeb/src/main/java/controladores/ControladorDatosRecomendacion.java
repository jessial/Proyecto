package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.Recomendacion;
import dto.DTORecomendacion;
import persistencia.entidad.RecomendacionEntidad;
import persistencia.repositorio.RecomendacionRepository;

public class ControladorDatosRecomendacion {

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private RecomendacionRepository recomendacionRepository;

	@Autowired
	private ControladorDatosAnalisis controladorDatosAnalisis;

	@Autowired
	private ControladorDatosFuenteXRecomendacion controladorDatosFuenteXRecomendacion;

	public List<DTORecomendacion> consultarPorAnalisis(Long codigoAnalisis) {
		List<Recomendacion> listRecomendacion = mapearListaADominio(
				recomendacionRepository.findBycodigoAnalisis(codigoAnalisis));
		return construirListaDTO(listRecomendacion);
	}

	private List<Recomendacion> mapearListaADominio(List<RecomendacionEntidad> recomendacionEntidadList) {
		return recomendacionEntidadList.stream().map(a -> mapearADominio(a))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	private List<DTORecomendacion> construirListaDTO(List<Recomendacion> listRecomendacion) {
		List<DTORecomendacion> listDtoRecomendacion = new ArrayList<>();
		for (Recomendacion recomendacion : listRecomendacion) {
			listDtoRecomendacion.add(construirDTO(recomendacion));
		}
		return listDtoRecomendacion;
	}

	protected DTORecomendacion construirDTO(Object object) {
		Recomendacion recomendacion = (Recomendacion) object;
		DTORecomendacion dtoRecomendacion = new DTORecomendacion();
		dtoRecomendacion.setCodigoRecomendacion(recomendacion.getCodigoRecomendacion());
		dtoRecomendacion.setAnalisis(controladorDatosAnalisis.consultarAnalisisXId(recomendacion.getCodigoAnalisis()));
		dtoRecomendacion.setFechaRecomendacion(recomendacion.getFechaRecomendacion());
		dtoRecomendacion.setRecomendacionXFuente(controladorDatosFuenteXRecomendacion
				.consultarFuentePorRecomendacion(recomendacion.getCodigoRecomendacion()));
		return dtoRecomendacion;
	}

	protected Recomendacion construirDominio(Object object) {
		DTORecomendacion dtoRecomendacion = (DTORecomendacion) object;
		Recomendacion recomendacion = new Recomendacion();
		recomendacion.setCodigoRecomendacion(dtoRecomendacion.getCodigoRecomendacion());
		recomendacion.setCodigoAnalisis(dtoRecomendacion.getAnalisis().getCodigoAnalisis());
		recomendacion.setFechaRecomendacion(dtoRecomendacion.getFechaRecomendacion());

		return recomendacion;
	}

	protected Recomendacion mapearADominio(Object object) {
		RecomendacionEntidad recomendacionEntidad = (RecomendacionEntidad) object;
		return mapperDozer.map(recomendacionEntidad, Recomendacion.class);
	}

	protected RecomendacionEntidad mapearAEntidad(Object object) {
		Recomendacion recomendacion = (Recomendacion) object;
		return mapperDozer.map(recomendacion, RecomendacionEntidad.class);
	}

}
