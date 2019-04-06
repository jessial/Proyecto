package controladores;

import java.util.ArrayList;
import java.util.List;

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
		completarObjeto(lugaresModelo, lugaresEntidad);
		return lugaresModelo;
	}

	public List<Lugar> consultarLugaresPorUsuario(Long cedula) {
		List<Lugar> lugaresModelo = new ArrayList<>();
		List<LugarEntidad> lugaresEntidad = lugarRepository.findByCodigoUsuario(cedula);
		completarObjeto(lugaresModelo, lugaresEntidad);
		return lugaresModelo;
	}

	private void completarObjeto(List<Lugar> lugaresModelo, List<LugarEntidad> lugaresEntidad) {
		lugaresEntidad.forEach(lugar -> {
			Usuario usuario = controladorDatosUsuario.consultarPorCedula(lugar.getCodigoUsuario());
			lugaresModelo.add(convertirLugarAModelo(lugar, usuario));

		});
	}

	public void guardarLugar(Lugar lugar) {
		lugarRepository.save(convertirLugarAEntidad(lugar));

	}

	public void eliminarLugar(Long codigoLugar) {
		List<ParcelaEntidad> lugaresAsociados = parcelaRepository.findByCodigoLugar(codigoLugar);
		if (lugaresAsociados.isEmpty()) {
			lugarRepository.deleteById(codigoLugar);
		}
	}

	public LugarEntidad consultarLugarPorId(Long id) {
		LugarEntidad lugarEntidad = new LugarEntidad();
		mapperDozer.map(lugarRepository.findByCodigoLugar(id), lugarEntidad);
		return lugarEntidad;
	}

	private Lugar convertirLugarAModelo(LugarEntidad lugarEntidad, Usuario usuario) {

		return new Lugar(lugarEntidad.getCodigoLugar(), lugarEntidad.getNombre(), usuario, lugarEntidad.getUbicacion());
	}

	private LugarEntidad convertirLugarAEntidad(Lugar lugar) {
		return new LugarEntidad(lugar.getCodigoLugar(), lugar.getNombre(), lugar.getUsuario().getCedula(),
				lugar.getUbicacion());
	}

	public Lugar consultarLugarXId(Long codigoLugar) {
		Lugar lugar = new Lugar();
		mapperDozer.map(lugarRepository.findByCodigoLugar(codigoLugar), lugar);
		return construirObjetoLugar(lugar);
	}

	private Lugar construirObjetoLugar(Lugar lugar) {
		lugar.setUsuario(controladorDatosUsuario.consultarPorCedula(lugar.getCodigoUsuario()));
		return lugar;
	}
}
