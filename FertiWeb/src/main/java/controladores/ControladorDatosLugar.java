package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.Lugar;
import dominio.Usuario;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import persistencia.entidad.LugarEntidad;
import persistencia.entidad.ParcelaEntidad;
import persistencia.repositorio.LugarRepository;
import persistencia.repositorio.ParcelaRepository;

@AllArgsConstructor
@NoArgsConstructor
public class ControladorDatosLugar {

	@Autowired
	private LugarRepository lugarRepository;

	@Autowired
	private ControladorDatosUsuario controladorDatosUsuario;

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private ParcelaRepository parcelaRepository;

	public List<Lugar> consultarFincas() {
		List<Lugar> lugaresModelo = new ArrayList<>();
		List<LugarEntidad> lugaresEntidad = lugarRepository.findAll();
		lugaresEntidad.forEach(lugar -> {
			Usuario usuario = controladorDatosUsuario.consultarPorCedula(lugar.getCodigoUsuario());
			lugaresModelo.add(convertirLugarAModelo(lugar, usuario));

		});
		return lugaresModelo;
	}

	public void guardarLugar(Lugar lugar) {
		LugarEntidad lugarEntidad = new LugarEntidad();
		mapperDozer.map(lugar, lugarEntidad);
		lugarRepository.save(lugarEntidad);

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

	private Lugar convertirLugarAModelo(LugarEntidad lugarEntidad, Usuario usuario) {

		return new Lugar(lugarEntidad.getCodigoLugar(), lugarEntidad.getNombre(), usuario, lugarEntidad.getUbicacion());
	}
}
