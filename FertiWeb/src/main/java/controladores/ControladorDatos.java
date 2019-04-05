package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.Parcela;
import dominio.Recomendacion;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import persistencia.entidad.ParcelaEntidad;
import persistencia.entidad.RecomendacionEntidad;
import persistencia.repositorio.ParcelaRepository;
import persistencia.repositorio.RecomendacionRepository;

@AllArgsConstructor
@NoArgsConstructor
public class ControladorDatos {

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private ParcelaRepository parcelaRepository;

	@Autowired
	private RecomendacionRepository recomendacionRepository;

	// Guardar

	public void guardarParcela(Parcela parcela) {
		ParcelaEntidad parcelaEntidad = new ParcelaEntidad();
		mapperDozer.map(parcela, parcelaEntidad);
		parcelaRepository.save(parcelaEntidad);
	}

	public ImmutablePair<List<Parcela>, List<Long>> consultarParcelasPorLugares(List<Long> codigos) {
		return mapearParcelas(parcelaRepository.findByCodigoParcelaIn(codigos));
	}

	private ImmutablePair<List<Parcela>, List<Long>> mapearParcelas(List<ParcelaEntidad> parcelasEntidad) {
		List<Parcela> parcelas = parcelasEntidad.stream().map(a -> mapperDozer.map(a, Parcela.class))
				.collect(Collectors.toCollection(ArrayList::new));
		List<Long> codigos = parcelas.stream().map(a -> a.getCodigoLugar())
				.collect(Collectors.toCollection(ArrayList::new));
		return new ImmutablePair<>(parcelas, codigos);
	}

	public List<Recomendacion> consultarRecomendacionesPorParcela(List<Long> codigos) {
		return mapearRecomendaciones(recomendacionRepository.findByCodigoParcelaIn(codigos));
	}

	private List<Recomendacion> mapearRecomendaciones(List<RecomendacionEntidad> recomendacionesEntidad) {
		return recomendacionesEntidad.stream().map(a -> mapperDozer.map(a, Recomendacion.class))
				.collect(Collectors.toCollection(ArrayList::new));
	}

}
