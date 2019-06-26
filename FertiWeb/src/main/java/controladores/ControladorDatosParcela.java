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

import dominio.Parcela;
import dto.DTOParcela;
import dto.DTOParcelaPaginado;
import dto.Paginador;
import persistencia.entidad.ParcelaEntidad;
import persistencia.repositorio.ParcelaRepository;

public class ControladorDatosParcela extends ControladorDatos {

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private ParcelaRepository parcelaRepository;

	@Autowired
	private ControladorDatosLugar controladorDatosLugar;

	@Autowired
	private ControladorDatosTipoCultivo controladorDatosTipoCultivo;

	public List<DTOParcela> consultarParcela() {
		List<Parcela> listaParcela = mapearListaADominio(parcelaRepository.findAll());
		return construirListaDTO(listaParcela);
	}

	private List<Parcela> mapearListaADominio(List<ParcelaEntidad> parcelaEntidadList) {
		return parcelaEntidadList.stream().map(a -> mapearADominio(a)).collect(Collectors.toCollection(ArrayList::new));
	}

	public ParcelaEntidad consultarParcelaPorId(Long id) {
		ParcelaEntidad parcelaEntidad = new ParcelaEntidad();
		mapperDozer.map(parcelaRepository.findByCodigoParcela(id), parcelaEntidad);
		return parcelaEntidad;
	}

	public DTOParcela consultarParcelaXId(Long codigoAnalisis) {
		return construirDTO(mapearADominio(parcelaRepository.findByCodigoParcela(codigoAnalisis)));
	}

	private List<DTOParcela> construirListaDTO(List<Parcela> listParcela) {
		List<DTOParcela> listDtoParcela = new ArrayList<>();
		for (Parcela parcela : listParcela) {
			listDtoParcela.add(construirDTO(parcela));
		}
		return listDtoParcela;
	}

	@Override
	protected DTOParcela construirDTO(Object object) {
		Parcela parcela = (Parcela) object;
		DTOParcela dtoParcela = new DTOParcela();
		dtoParcela.setCodigoParcela(parcela.getCodigoParcela());
		dtoParcela.setFechaSiembra(parcela.getFechaSiembra());
		dtoParcela.setArea(parcela.getArea());
		dtoParcela.setLugar(controladorDatosLugar.consultarLugarXId(parcela.getCodigoLugar()));
		dtoParcela.setTipoCultivo(
				controladorDatosTipoCultivo.consultarTipoCultivoXId(parcela.getCodigoCultivoSembrado()));
		return dtoParcela;
	}

	@Override
	public Parcela construirDominio(Object object) {
		DTOParcela dtoParcela = (DTOParcela) object;
		Parcela parcela = new Parcela();
		parcela.setCodigoParcela(dtoParcela.getCodigoParcela());
		parcela.setFechaSiembra(dtoParcela.getFechaSiembra());
		parcela.setArea(dtoParcela.getArea());
		parcela.setCodigoLugar(dtoParcela.getLugar().getCodigoLugar());
		parcela.setCodigoCultivoSembrado(dtoParcela.getTipoCultivo().getCodigoTipoCultivo());
		return parcela;
	}

	@Override
	protected Parcela mapearADominio(Object object) {
		ParcelaEntidad parcelaEntidad = (ParcelaEntidad) object;
		return mapperDozer.map(parcelaEntidad, Parcela.class);
	}

	@Override
	protected ParcelaEntidad mapearAEntidad(Object object) {
		Parcela parcela = (Parcela) object;
		return mapperDozer.map(parcela, ParcelaEntidad.class);
	}

	@Transactional
	@Override
	public void guardar(Object object) {
		Parcela parcela = (Parcela) object;
		parcelaRepository.save(mapearAEntidad(parcela));
	}

	@Transactional
	public void eliminarParcela(Long codigoParcela) {
		parcelaRepository.deleteById(codigoParcela);

	}

	public Object consultarParcelaPorUsuario(Long cedula) {
		List<Parcela> listaParcela = mapearListaADominio(parcelaRepository.findAllByCodigoUsuario(cedula));
		return construirListaDTO(listaParcela);
	}

	public DTOParcelaPaginado consultarTodosPaginado(int pagina) {
		Pageable paginador = PageRequest.of(pagina, 10);
		return construirDTOPaginado(parcelaRepository.findAll(paginador));
	}

	private DTOParcelaPaginado construirDTOPaginado(Page<ParcelaEntidad> resultado) {
		Paginador paginador = new Paginador();
		paginador.setNumeroPagina(resultado.getNumber());
		paginador.setTamano(resultado.getNumberOfElements());
		paginador.setTotalElementos(resultado.getTotalElements());
		paginador.setTotalPaginas(resultado.getTotalPages());
		DTOParcelaPaginado dtoParcelaPaginado = new DTOParcelaPaginado();
		dtoParcelaPaginado.setParcela(construirListaDTO(mapearListaADominio(resultado.getContent())));
		dtoParcelaPaginado.setPaginador(paginador);
		return dtoParcelaPaginado;
	}

	public DTOParcelaPaginado consultarConFiltroUsuario(String filtro, int pagina) {
		Pageable paginador = PageRequest.of(pagina, 10);
		return construirDTOPaginado(parcelaRepository.findAllLikeUsuarioNombre(filtro, paginador));
	}
}
