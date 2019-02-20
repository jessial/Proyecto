package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.Analisis;
import dominio.Elemento;
import dominio.Fuente;
import dominio.Lugar;
import dominio.Parcela;
import dominio.Recomendacion;
import dominio.Requerimiento;
import dominio.Rol;
import dominio.TipoCultivo;
import dominio.TipoFuente;
import dominio.Unidad;
import dominio.Usuario;
import dto.RequerimientoPorCultivo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import persistencia.entidad.AnalisisEntidad;
import persistencia.entidad.FuenteEntidad;
import persistencia.entidad.LugarEntidad;
import persistencia.entidad.ParcelaEntidad;
import persistencia.entidad.RecomendacionEntidad;
import persistencia.entidad.RequerimientoEntidad;
import persistencia.entidad.RolEntidad;
import persistencia.entidad.TipoCultivoEntidad;
import persistencia.entidad.TipoFuenteEntidad;
import persistencia.entidad.UsuarioEntidad;
import persistencia.repositorio.AnalisisRepository;
import persistencia.repositorio.ElementosRepository;
import persistencia.repositorio.FuenteRepository;
import persistencia.repositorio.LugarRepository;
import persistencia.repositorio.ParcelaRepository;
import persistencia.repositorio.RecomendacionRepository;
import persistencia.repositorio.RequerimientoRepository;
import persistencia.repositorio.RolRepository;
import persistencia.repositorio.TipoCultivoRepository;
import persistencia.repositorio.TipoFuenteRepository;
import persistencia.repositorio.UnidadRepository;
import persistencia.repositorio.UsuarioRepository;

@AllArgsConstructor
@NoArgsConstructor
public class ControladorDatos {

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private AnalisisRepository analisisRepository;

	@Autowired
	private RolRepository rolRepository;

	@Autowired
	private TipoCultivoRepository tipoCultivoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ParcelaRepository parcelaRepository;

	@Autowired
	private LugarRepository lugarRepository;

	@Autowired
	private RecomendacionRepository recomendacionRepository;

	@Autowired
	private RequerimientoRepository requerimientoRepository;

	@Autowired
	private TipoFuenteRepository tipoFuenteRepository;

	@Autowired
	private UnidadRepository unidadRepository;

	@Autowired
	private FuenteRepository fuenteRepository;

	@Autowired
	private ElementosRepository elementoRepository;

	// Consultar para front
	public List<Rol> consultarRoles() {
		List<Rol> roles = new ArrayList<>();
		mapperDozer.map(rolRepository.findAll(), roles);
		return roles;
	}

	public List<RequerimientoPorCultivo> consultarRequermientos() {
		return requerimientoRepository.getTodos();
	}

	public List<TipoFuente> consultarTipoFuente() {
		return tipoFuenteRepository.getTodos();
	}

	public List<Unidad> consultarUnidad() {
		List<Unidad> unidad = new ArrayList<>();
		mapperDozer.map(unidadRepository.findAll(), unidad);
		return unidad;
	}

	public List<Fuente> consultarFuente() {
		return fuenteRepository.getTodos();
	}

	public List<TipoCultivo> consultarCultivo() {
		List<TipoCultivo> tiposCultivo = new ArrayList<>();
		List<TipoCultivoEntidad> tiposCultivoEntidad = tipoCultivoRepository.findAll();
		mapperDozer.map(tiposCultivoEntidad, tiposCultivo);
		return tiposCultivo;
	}

	// consultar para app
	public List<Rol> consultarRolesParaApp() {
		List<Rol> roles = new ArrayList<>();
		boolean estado = true;
		mapperDozer.map(rolRepository.findByEstado(estado), roles);
		return roles;
	}

	public List<Elemento> consultarElementosParaApp() {
		List<Elemento> elementos = new ArrayList<>();
		mapperDozer.map(elementoRepository.findAll(), elementos);
		return elementos;
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

	public Rol consultarRolPorCodigo(Long codigoRol) {
		Rol rol = new Rol();
		mapperDozer.map(rolRepository.findByCodigo(codigoRol), rol);
		return rol;
	}

	// Guardar

	public void guardarAnalisis(Analisis analisisSuelo) {
		AnalisisEntidad analisisEntidad = new AnalisisEntidad();
		mapperDozer.map(analisisSuelo, analisisEntidad);
		analisisRepository.save(analisisEntidad);
	}

	public void guardarTipoCultivo(TipoCultivo tipoCultivo) {
		TipoCultivoEntidad tipoCultivoEntidad = new TipoCultivoEntidad();
		mapperDozer.map(tipoCultivo, tipoCultivoEntidad);
		tipoCultivoRepository.save(tipoCultivoEntidad);
	}

	public void guardarRol(Rol rol) {
		RolEntidad rolEntidad = new RolEntidad();
		mapperDozer.map(rol, rolEntidad);
		rolRepository.save(rolEntidad);
	}

	public void guardarRequermiento(Requerimiento requerimiento) {
		RequerimientoEntidad requerimientoEntidad = new RequerimientoEntidad();
		mapperDozer.map(requerimiento, requerimientoEntidad);
		requerimientoRepository.save(requerimientoEntidad);
	}

	public void guardarTipoFuente(TipoFuente tipoFuente) {
		TipoFuenteEntidad tipoFuenteEntidad = new TipoFuenteEntidad();
		mapperDozer.map(tipoFuente, tipoFuenteEntidad);
		tipoFuenteRepository.save(tipoFuenteEntidad);

	}

	public void guardarFuente(Fuente fuente) {
		FuenteEntidad fuenteEntidad = new FuenteEntidad();
		mapperDozer.map(fuente, fuenteEntidad);
		fuenteRepository.save(fuenteEntidad);
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

	// Eliminar
	public void eliminarTipoCultivo(long codigoCultivoSembrado) {
		tipoCultivoRepository.deleteById(codigoCultivoSembrado);
	}

	public void eliminarRol(long codigoRol) {
		rolRepository.deleteById(codigoRol);
	}

	public void eliminarTipoFuente(long codigo) {
		tipoFuenteRepository.deleteById(codigo);
	}

	public void eliminarFuente(long codigoFuente) {
		fuenteRepository.deleteById(codigoFuente);
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
