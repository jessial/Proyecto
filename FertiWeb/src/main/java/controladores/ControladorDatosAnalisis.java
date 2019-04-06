package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.Analisis;
import dominio.Elemento;
import dominio.Lugar;
import dominio.Parcela;
import dominio.TipoCultivo;
import dominio.Unidad;
import dominio.Usuario;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import persistencia.entidad.AnalisisEntidad;
import persistencia.entidad.ElementosEntidad;
import persistencia.entidad.LugarEntidad;
import persistencia.entidad.ParcelaEntidad;
import persistencia.entidad.TipoCultivoEntidad;
import persistencia.entidad.UnidadEntidad;
import persistencia.repositorio.AnalisisRepository;

@AllArgsConstructor
@NoArgsConstructor
public class ControladorDatosAnalisis {

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private AnalisisRepository analisisRepository;

	@Autowired
	private ControladorDatosTipoCultivo controladorDatosTipoCultivo;

	@Autowired
	private ControladorDatosElemento controladorDatosElemento;

	@Autowired
	private ControladorDatosUsuario controladorDatosUsuario;

	@Autowired
	private ControladorDatosParcela controladorDatosParcela;

	@Autowired
	private ControladorDatosLugar controladorDatosLugar;

	@Autowired
	private ControladorDatosUnidad controladorDatosUnidad;

	public List<Analisis> consultarAnalisis() {
		List<Analisis> listaAnalisis = new ArrayList<>();
		List<AnalisisEntidad> analisisEntidad = analisisRepository.findAll();
		analisisEntidad.forEach(analisis -> {
			ParcelaEntidad parcelaEntidad = controladorDatosParcela.consultarParcelaPorId(analisis.getCodigoParcela());

			// Completar objeto parcela
			LugarEntidad lugarEntidad = controladorDatosLugar.consultarLugarPorId(parcelaEntidad.getCodigoLugar());
			TipoCultivoEntidad tipoCultivoEntidad = controladorDatosTipoCultivo
					.consultarTipoCultivoPorId(parcelaEntidad.getCodigoCultivoSembrado());

			// Completar objeto lugar
			Usuario usuario = controladorDatosUsuario.consultarPorCedula(lugarEntidad.getCodigoUsuario());

			ElementosEntidad elementoEntidad = controladorDatosElemento
					.consultarElementosPorId(analisis.getCodigoElemento());

			UnidadEntidad unidadEntidad = controladorDatosUnidad.consultarUnidadPorId(analisis.getCodigoUnidad());

			listaAnalisis.add(convertirAnalisisAModelo(analisis, parcelaEntidad, tipoCultivoEntidad, elementoEntidad,
					unidadEntidad, lugarEntidad, usuario));

		});
		return listaAnalisis;
	}

	public void guardarAnalisis(Analisis analisisSuelo) {
		AnalisisEntidad analisisEntidad = new AnalisisEntidad();
		mapperDozer.map(analisisSuelo, analisisEntidad);
		analisisRepository.save(analisisEntidad);
	}

	public List<Analisis> consultarAnalisisPorParcela(List<Long> codigos) {
		return mapearAnalisis(analisisRepository.findByCodigoParcelaIn(codigos));
	}

	private List<Analisis> mapearAnalisis(List<AnalisisEntidad> analisisEntidadList) {
		return analisisEntidadList.stream().map(a -> mapperDozer.map(a, Analisis.class))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	private Analisis convertirAnalisisAModelo(AnalisisEntidad analisisEntidad, ParcelaEntidad parcelaEntidad,
			TipoCultivoEntidad tipoCultivoEntidad, ElementosEntidad elementoEntidad, UnidadEntidad unidadEntidad,
			LugarEntidad lugarEntidad, Usuario usuario) {

		TipoCultivo tipoCultivoDominio = new TipoCultivo(tipoCultivoEntidad.getCodigoTipoCultivo(),
				tipoCultivoEntidad.getNombre(), tipoCultivoEntidad.getVariedad(), tipoCultivoEntidad.isEstado());

		Lugar lugarDominio = new Lugar(lugarEntidad.getCodigoLugar(), lugarEntidad.getNombre(), usuario,
				lugarEntidad.getUbicacion());

		Parcela parcelaDominio = new Parcela(parcelaEntidad.getCodigoParcela(), lugarDominio, tipoCultivoDominio,
				parcelaEntidad.getArea(), parcelaEntidad.getFechaPosibleSiembra());

		Elemento elementoDominio = new Elemento(elementoEntidad.getCodigoElemento(), elementoEntidad.getElemento());

		Unidad unidadDominio = new Unidad(unidadEntidad.getCodigoUnidad(), unidadEntidad.getNombreUnidad());

		return new Analisis(analisisEntidad.getCodigoAnalisis(), parcelaDominio, analisisEntidad.getFechaAnalisis(),
				elementoDominio, analisisEntidad.getCantidad(), unidadDominio);
	}
}
