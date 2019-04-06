package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.Analisis;
import dominio.ElementoXAnalisis;
import dto.DtoAnalisis;
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
	private ControladorDatosParcela controladorDatosParcela;
	
	@Autowired
	private ControladorDatosElementoXAnalisis controladorDatosElementoXAnalisis;

	public List<DtoAnalisis> consultarTodos() {
		List<Analisis> listAnalisis = mapearAnalisis(analisisRepository.findAll());
		return consultarElementosPorAnalisis(listAnalisis);
	}

	public void guardarAnalisis(ElementoXAnalisis analisisSuelo) {
		AnalisisEntidad analisisEntidad = new AnalisisEntidad();
		mapperDozer.map(analisisSuelo, analisisEntidad);
		analisisRepository.save(analisisEntidad);
	}

	public List<DtoAnalisis> consultarAnalisisPorParcela(List<Long> codigos) {
		List<Analisis> listAnalisis = mapearAnalisis(analisisRepository.findByCodigoParcelaIn(codigos));
		return consultarElementosPorAnalisis(listAnalisis);
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

	private List<DtoAnalisis> consultarElementosPorAnalisis(List<Analisis> listAnalisis) {
		List<DtoAnalisis> listDtoAnalisis = new ArrayList<>();
		for (Analisis analisis : listAnalisis) {
			DtoAnalisis dtoAnalisis = new DtoAnalisis();
			dtoAnalisis.setCodigoAnalisis(analisis.getCodigoAnalisis());
			dtoAnalisis.setFechaAnalisis(analisis.getFechaAnalisis());
			dtoAnalisis.setDtoParcela(controladorDatosParcela.consultarParcelaXId(analisis.getCodigoAnalisis()));
			dtoAnalisis.setElementos(controladorDatosElementoXAnalisis.consultarElementoPorAnalisis(analisis.getCodigoAnalisis()));
			listDtoAnalisis.add(dtoAnalisis);
		}
		return listDtoAnalisis;
	}
}
