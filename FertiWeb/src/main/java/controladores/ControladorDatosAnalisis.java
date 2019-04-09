package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dominio.Analisis;
import dto.DTOAnalisis;
import persistencia.entidad.AnalisisEntidad;
import persistencia.repositorio.AnalisisRepository;

public class ControladorDatosAnalisis extends ControladorDatos {

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private AnalisisRepository analisisRepository;

	@Autowired
	private ControladorDatosParcela controladorDatosParcela;

	@Autowired
	private ControladorDatosElementoXAnalisis controladorDatosElementoXAnalisis;

	public List<DTOAnalisis> consultarTodos() {
		List<Analisis> listAnalisis = mapearListaADominio(analisisRepository.findAll());
		return construirListaDTO(listAnalisis);
	}

	public List<Analisis> consultarAnalisisPorParcela(long codigoParcela) {
		List<Analisis> listAnalisis = mapearListaADominio(analisisRepository.findByCodigoParcela(codigoParcela));
		construirDTO(listAnalisis);
		return listAnalisis;
	}

	private List<Analisis> mapearListaADominio(List<AnalisisEntidad> analisisEntidadList) {
		return analisisEntidadList.stream().map(a -> mapearADominio(a))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	private List<DTOAnalisis> construirListaDTO(List<Analisis> listAnalisis) {
		List<DTOAnalisis> listDtoAnalisis = new ArrayList<>();
		for (Analisis analisis : listAnalisis) {
			listDtoAnalisis.add(construirDTO(analisis));
		}
		return listDtoAnalisis;
	}

	@Override
	protected DTOAnalisis construirDTO(Object object) {
		Analisis analisis = (Analisis) object;
		DTOAnalisis dtoAnalisis = new DTOAnalisis();
		dtoAnalisis.setCodigoAnalisis(analisis.getCodigoAnalisis());
		dtoAnalisis.setFechaAnalisis(analisis.getFechaAnalisis());
		dtoAnalisis.setParcela(controladorDatosParcela.consultarParcelaXId(analisis.getCodigoParcela()));
		dtoAnalisis.setElementos(
				controladorDatosElementoXAnalisis.consultarElementoPorAnalisis(analisis.getCodigoAnalisis()));

		return dtoAnalisis;
	}

	@Override
	protected Analisis mapearADominio(Object object) {
		AnalisisEntidad analisisEntidad = (AnalisisEntidad) object;
		return mapperDozer.map(analisisEntidad, Analisis.class);
	}

	@Override
	protected AnalisisEntidad mapearAEntidad(Object object) {
		Analisis analisis = (Analisis) object;
		return mapperDozer.map(analisis, AnalisisEntidad.class);
	}

	@Transactional
	@Override
	public void guardar(Object object) {
		Analisis analisis = (Analisis) object;
		analisisRepository.save(mapearAEntidad(analisis));
	}

}
