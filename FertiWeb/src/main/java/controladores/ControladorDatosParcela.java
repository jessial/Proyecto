package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.Lugar;
import dominio.Parcela;
import dominio.TipoCultivo;
import dominio.Usuario;
import dto.DTOParcela;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import persistencia.entidad.LugarEntidad;
import persistencia.entidad.ParcelaEntidad;
import persistencia.entidad.TipoCultivoEntidad;
import persistencia.repositorio.ParcelaRepository;

@AllArgsConstructor
@NoArgsConstructor
public class ControladorDatosParcela {

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private ParcelaRepository parcelaRepository;

	@Autowired
	private ControladorDatosLugar controladorDatosLugar;

	@Autowired
	private ControladorDatosUsuario controladorDatosUsuario;

	@Autowired
	private ControladorDatosTipoCultivo controladorDatosTipoCultivo;

	public void guardarParcela(Parcela parcela) {
		parcelaRepository.save(convertirParcelaAEntidad(parcela));
	}

	public List<Parcela> consultarParcela() {
		List<Parcela> listaParcela = new ArrayList<>();
		List<ParcelaEntidad> parcelaEntidad = parcelaRepository.findAll();
		parcelaEntidad.forEach(parcela -> {
			LugarEntidad lugarEntidad = controladorDatosLugar.consultarLugarPorId(parcela.getCodigoLugar());

			// Completar objeto lugar
			Usuario usuario = controladorDatosUsuario.consultarPorCedula(lugarEntidad.getCodigoUsuario());

			TipoCultivoEntidad tipoCultivoEntidad = controladorDatosTipoCultivo
					.consultarTipoCultivoPorId(parcela.getCodigoCultivoSembrado());

			listaParcela.add(convertirParcelaAModelo(parcela, tipoCultivoEntidad, lugarEntidad, usuario));

		});

		return listaParcela;

	}

	public ParcelaEntidad consultarParcelaPorId(Long id) {
		ParcelaEntidad parcelaEntidad = new ParcelaEntidad();
		mapperDozer.map(parcelaRepository.findByCodigoParcela(id), parcelaEntidad);
		return parcelaEntidad;
	}

	public ImmutablePair<List<Parcela>, List<Long>> consultarParcelasPorLugares(List<Long> codigos) {
		return mapearParcelas(parcelaRepository.findByCodigoParcelaIn(codigos));
	}

	private ImmutablePair<List<Parcela>, List<Long>> mapearParcelas(List<ParcelaEntidad> parcelasEntidad) {
		List<Parcela> parcelas = parcelasEntidad.stream().map(a -> mapperDozer.map(a, Parcela.class))
				.collect(Collectors.toCollection(ArrayList::new));
		List<Long> codigos = parcelas.stream().map(a -> a.getLugar().getCodigoLugar())
				.collect(Collectors.toCollection(ArrayList::new));
		return new ImmutablePair<>(parcelas, codigos);
	}

	private Parcela convertirParcelaAModelo(ParcelaEntidad parcelaEntidad, TipoCultivoEntidad tipoCultivoEntidad,
			LugarEntidad lugarEntidad, Usuario usuario) {

		TipoCultivo tipoCultivoDominio = new TipoCultivo(tipoCultivoEntidad.getCodigoTipoCultivo(),
				tipoCultivoEntidad.getNombre(), tipoCultivoEntidad.getVariedad(), tipoCultivoEntidad.isEstado());

		Lugar lugarDominio = new Lugar(lugarEntidad.getCodigoLugar(), lugarEntidad.getNombre(), usuario,
				lugarEntidad.getUbicacion());

		return new Parcela(parcelaEntidad.getCodigoParcela(), lugarDominio, tipoCultivoDominio,
				parcelaEntidad.getArea(), parcelaEntidad.getFechaSiembra());

	}

	public DTOParcela consultarParcelaXId(Long codigoAnalisis) {
		Parcela parcela = new Parcela();
		mapperDozer.map(parcelaRepository.findByCodigoParcela(codigoAnalisis), parcela);
		return construirObjetoParcela(parcela);
	}

	private DTOParcela construirObjetoParcela(Parcela parcela) {
		DTOParcela dtoParcela = new DTOParcela();
		dtoParcela.setCodigoParcela(parcela.getCodigoParcela());
		dtoParcela.setFechaSiembra(parcela.getFechaSiembra());
		dtoParcela.setArea(parcela.getArea());
		dtoParcela.setLugar(controladorDatosLugar.consultarLugarXId(parcela.getCodigoLugar()));
		dtoParcela.setTipoCultivo(
				controladorDatosTipoCultivo.consultarTipoCultivoXId(parcela.getCodigoCultivoSembrado()));
		return dtoParcela;
	}

	public void eliminarParcela(Long codigoParcela) {
		parcelaRepository.deleteById(codigoParcela);

	}

	private ParcelaEntidad convertirParcelaAEntidad(Parcela parcela) {
		return new ParcelaEntidad(parcela.getCodigoParcela(), parcela.getTipoCultivo().getCodigoTipoCultivo(),
				parcela.getLugar().getCodigoLugar(), parcela.getArea(), parcela.getFechaSiembra());

	}
}
