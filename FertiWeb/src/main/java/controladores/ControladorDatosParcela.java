package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import constantes.MensajesConstantes;
import dominio.Parcela;
import dto.DTOParcela;
import excepciones.ExcepcionClaveForanea;
import persistencia.entidad.AnalisisEntidad;
import persistencia.entidad.ParcelaEntidad;
import persistencia.repositorio.AnalisisRepository;
import persistencia.repositorio.ParcelaRepository;

public class ControladorDatosParcela extends ControladorDatos {

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private ParcelaRepository parcelaRepository;

	@Autowired
	private AnalisisRepository analisisRepository;

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
		List<AnalisisEntidad> analisis = analisisRepository.findByCodigoParcela(codigoParcela);
		if (!analisis.isEmpty())
			throw new ExcepcionClaveForanea(MensajesConstantes.ERROR_ASOCIACION_ANALISIS);
		parcelaRepository.deleteById(codigoParcela);

	}

	public Object consultarParcelaPorUsuario(Long cedula) {
		List<Parcela> listaParcela = mapearListaADominio(parcelaRepository.findAllByCodigoUsuario(cedula));
		return construirListaDTO(listaParcela);
	}
}
