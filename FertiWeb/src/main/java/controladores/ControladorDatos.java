package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.Analisis;
import dominio.Lugar;
import dominio.Parcela;
import dominio.Recomendacion;
import dominio.Usuario;
import dto.AnalisisAdministrador;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import persistencia.entidad.AnalisisEntidad;
import persistencia.entidad.LugarEntidad;
import persistencia.entidad.ParcelaEntidad;
import persistencia.entidad.RecomendacionEntidad;
import persistencia.entidad.UsuarioEntidad;
import persistencia.repositorio.AnalisisRepository;
import persistencia.repositorio.LugarRepository;
import persistencia.repositorio.ParcelaRepository;
import persistencia.repositorio.RecomendacionRepository;
import persistencia.repositorio.UsuarioRepository;

@AllArgsConstructor
@NoArgsConstructor
public class ControladorDatos {

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private AnalisisRepository analisisRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ParcelaRepository parcelaRepository;

	@Autowired
	private LugarRepository lugarRepository;

	@Autowired
	private RecomendacionRepository recomendacionRepository;

	public List<AnalisisAdministrador> consultarAnalisisParaAdministrador() {
		return analisisRepository.getTodos();
	}

	public List<Lugar> consultarLugarParaApp() {
		List<Lugar> lugar = new ArrayList<>();
		mapperDozer.map(lugarRepository.findAll(), lugar);
		return lugar;
	}

	public Usuario consultarPorCedula(Long cedula) {
		Usuario usuario = new Usuario();
		mapperDozer.map(
				Optional.ofNullable(usuarioRepository.findByCedula(cedula)).orElseGet(() -> new UsuarioEntidad()),
				usuario);
		return usuario;
	}

	// Guardar

	public void guardarAnalisis(Analisis analisisSuelo) {
		AnalisisEntidad analisisEntidad = new AnalisisEntidad();
		mapperDozer.map(analisisSuelo, analisisEntidad);
		analisisRepository.save(analisisEntidad);
	}

	public void guardarLugar(Lugar lugar) {
		LugarEntidad lugarEntidad = new LugarEntidad();
		mapperDozer.map(lugar, lugarEntidad);
		lugarRepository.save(lugarEntidad);

	}

	public void guardarParcela(Parcela parcela) {
		ParcelaEntidad parcelaEntidad = new ParcelaEntidad();
		mapperDozer.map(parcela, parcelaEntidad);
		parcelaRepository.save(parcelaEntidad);
	}

	public void eliminarLugar(Long codigoLugar) {
		List<ParcelaEntidad> lugaresAsociados = parcelaRepository.findByCodigoLugar(codigoLugar);
		if (lugaresAsociados.isEmpty()) {
			lugarRepository.deleteById(codigoLugar);
		}
	}

	public ImmutablePair<List<Lugar>, List<Long>> consultarLugaresPorUsuario(Long cedula) {
		return mapearLugares(lugarRepository.findByCodigoUsuario(cedula));
	}

	private ImmutablePair<List<Lugar>, List<Long>> mapearLugares(List<LugarEntidad> lugaresEntidad) {
		List<Lugar> lugares = lugaresEntidad.stream().map(a -> mapperDozer.map(a, Lugar.class))
				.collect(Collectors.toCollection(ArrayList::new));
		List<Long> codigos = lugares.stream().map(a -> a.getCodigoLugar())
				.collect(Collectors.toCollection(ArrayList::new));
		return new ImmutablePair<>(lugares, codigos);
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

	public List<Analisis> consultarAnalisisPorParcela(List<Long> codigos) {
		return mapearAnalisis(analisisRepository.findByCodigoParcelaIn(codigos));
	}

	private List<Analisis> mapearAnalisis(List<AnalisisEntidad> analisisEntidadList) {
		return analisisEntidadList.stream().map(a -> mapperDozer.map(a, Analisis.class))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public List<Recomendacion> consultarRecomendacionesPorParcela(List<Long> codigos) {
		return mapearRecomendaciones(recomendacionRepository.findByCodigoParcelaIn(codigos));
	}

	private List<Recomendacion> mapearRecomendaciones(List<RecomendacionEntidad> recomendacionesEntidad) {
		return recomendacionesEntidad.stream().map(a -> mapperDozer.map(a, Recomendacion.class))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public void guardarUsuarioNuevo(Usuario usuario) {
		UsuarioEntidad usuarioEntidad = new UsuarioEntidad();
		if (!usuarioExisteEnBd(usuario.getCedula())) {
			mapperDozer.map(usuario, usuarioEntidad);
			usuarioRepository.save(usuarioEntidad);
		}

	}

	public boolean usuarioExisteEnBd(Long cedula) {
		return null != usuarioRepository.findByCedula(cedula);
	}

}
