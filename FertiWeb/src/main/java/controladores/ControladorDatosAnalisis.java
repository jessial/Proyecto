package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import dominio.Analisis;
import dto.DTOAnalisis;
import dto.DTOAnalisisPaginado;
import dto.Paginador;
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

	public DTOAnalisis consultarAnalisisXId(Long codigoAnalisis) {
		return construirDTO(mapearADominio(analisisRepository.findByCodigoAnalisis(codigoAnalisis)));
	}

	@Override
	protected Analisis construirDominio(Object object) {
		DTOAnalisis dtoAnalisis = (DTOAnalisis) object;
		Analisis analisis = new Analisis();
		analisis.setCodigoAnalisis(dtoAnalisis.getCodigoAnalisis());
		analisis.setCodigoParcela(dtoAnalisis.getParcela().getCodigoParcela());
		analisis.setFechaAnalisis(dtoAnalisis.getFechaAnalisis());
		return analisis;
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

	@Transactional
	public Analisis guardarAnalisis(Analisis analisis) {
		return mapearADominio(analisisRepository.save(mapearAEntidad(analisis)));
	}

	public void guardarAnalisis(DTOAnalisis dtoAnalisis) {
		Analisis analisis = construirDominio(dtoAnalisis);
		Long codigoAnalisis = guardarAnalisis(analisis).getCodigoAnalisis();
		controladorDatosElementoXAnalisis.guardarLista(dtoAnalisis.getElementos(), codigoAnalisis);
	}

	public List<DTOAnalisis> consultarXUsuario(Long codigoUsuario) {
		List<Analisis> listAnalisis = mapearListaADominio(analisisRepository.findAllByCodigoUsuario(codigoUsuario));
		return construirListaDTO(listAnalisis);
	}

	private DTOAnalisisPaginado construirDTO(Page<AnalisisEntidad> resultado) {
		Paginador paginador = new Paginador();
		paginador.setNumeroPagina(resultado.getNumber());
		paginador.setTamano(resultado.getNumberOfElements());
		paginador.setTotalElementos(resultado.getTotalElements());
		paginador.setTotalPaginas(resultado.getTotalPages());
		DTOAnalisisPaginado dtoAnalisisPaginado = new DTOAnalisisPaginado();
		dtoAnalisisPaginado.setAnalisis(construirListaDTO(mapearListaADominio(resultado.getContent())));
		dtoAnalisisPaginado.setPaginador(paginador);
		return dtoAnalisisPaginado;
	}

	public DTOAnalisisPaginado consultarTodosPaginado(int pagina) {
		Pageable paginador = PageRequest.of(pagina, 10);
		return construirDTO(analisisRepository.findAll(paginador));
	}

	public DTOAnalisisPaginado consultarXUsuarioPaginado(Long codigoUsuario, int pagina) {
		Pageable paginador = PageRequest.of(pagina, 10);
		return construirDTO(analisisRepository.findAllByCodigoUsuario(codigoUsuario, paginador));
	}

	public DTOAnalisisPaginado consultarAnalisisPorParcelaPaginado(long codigoParcela, int pagina) {
		Pageable paginador = PageRequest.of(pagina, 10);
		return construirDTO(analisisRepository.findByCodigoParcela(codigoParcela, paginador));
	}

	public DTOAnalisisPaginado consultarConFiltro1(String filtro, int pagina) {
		Pageable paginador = PageRequest.of(pagina, 10);
		return construirDTO(analisisRepository.findAllLikeLugarNombreUbicacion(filtro, paginador));
	}

	public Object consultarAnalisisPorUsuario(Long cedula) {
		List<Analisis> listAnalisis = mapearListaADominio(analisisRepository.findAllByCodigoUsuarioParaApp(cedula));
		return construirListaDTO(listAnalisis);

	}
}
