package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.Recomendacion;
import persistencia.entidad.RecomendacionEntidad;
import persistencia.repositorio.RecomendacionRepository;

public class ControladorDeDatosRecomendacion {

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private RecomendacionRepository recomendacionRepository;

	public List<Recomendacion> consultarRecomendacionesPorParcela(List<Long> codigos) {
		return mapearRecomendaciones(recomendacionRepository.findByCodigoParcelaIn(codigos));
	}

	private List<Recomendacion> mapearRecomendaciones(List<RecomendacionEntidad> recomendacionesEntidad) {
		return recomendacionesEntidad.stream().map(a -> mapperDozer.map(a, Recomendacion.class))
				.collect(Collectors.toCollection(ArrayList::new));
	}

}
