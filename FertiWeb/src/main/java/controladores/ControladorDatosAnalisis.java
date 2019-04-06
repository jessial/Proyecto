package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.Analisis;
import dominio.ElementoXAnalisis;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import persistencia.entidad.AnalisisEntidad;
import persistencia.repositorio.AnalisisRepository;

@AllArgsConstructor
@NoArgsConstructor
public class ControladorDatosAnalisis {

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private AnalisisRepository analisisRepository;

	@Autowired
	private ControladorDatosElementoXAnalisis controladorDatosElementoXAnalisis;

	public List<ElementoXAnalisis> consultarAnalisis() {
		return new ArrayList<>();
	}

	public void guardarAnalisis(ElementoXAnalisis analisisSuelo) {
		AnalisisEntidad analisisEntidad = new AnalisisEntidad();
		mapperDozer.map(analisisSuelo, analisisEntidad);
		analisisRepository.save(analisisEntidad);
	}

	public List<Analisis> consultarAnalisisPorParcela(List<Long> codigos) {
		List<Analisis> listAnalisis = mapearAnalisis(analisisRepository.findByCodigoParcelaIn(codigos));
		consultarElementosPorAnalisis(listAnalisis);
		return listAnalisis;
	}

	private List<Analisis> mapearAnalisis(List<AnalisisEntidad> analisisEntidadList) {
		return analisisEntidadList.stream().map(a -> mapperDozer.map(a, Analisis.class))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public List<Analisis> consultarAnalisisPorParcela(long codigoParcela) {
		List<Analisis> listAnalisis = mapearAnalisis(analisisRepository.findByCodigoParcela(codigoParcela));
		consultarElementosPorAnalisis(listAnalisis);
		return listAnalisis;
	}

	private void consultarElementosPorAnalisis(List<Analisis> listAnalisis) {
		for (Analisis analisis : listAnalisis) {
			analisis.setElementos(
					controladorDatosElementoXAnalisis.consultarElementoPorAnalisis(analisis.getCodigoAnalisis()));
		}
	}
}
