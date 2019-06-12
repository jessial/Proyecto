package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import constantes.MensajesConstantes;
import dominio.Lugar;
import dto.DTOLugar;
import excepciones.ExcepcionClaveForanea;
import persistencia.entidad.LugarEntidad;
import persistencia.entidad.ParcelaEntidad;
import persistencia.repositorio.LugarRepository;
import persistencia.repositorio.ParcelaRepository;

public class ControladorDatosLugar extends ControladorDatos {

	@Autowired
	private LugarRepository lugarRepository;

	@Autowired
	private ControladorDatosUsuario controladorDatosUsuario;

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private ParcelaRepository parcelaRepository;

	public List<DTOLugar> consultarFincas() {
		List<Lugar> lugaresModelo = mapearListaADominio(lugarRepository.findAll());
		return construirListaDTO(lugaresModelo);
	}

	public List<DTOLugar> consultarLugaresPorUsuario(Long cedula) {
		List<Lugar> lugaresModelo = mapearListaADominio(lugarRepository.findByCodigoUsuario(cedula));
		return construirListaDTO(lugaresModelo);
	}

	private List<DTOLugar> construirListaDTO(List<Lugar> listLugar) {
		List<DTOLugar> listDtoLugar = new ArrayList<>();
		for (Lugar lugar : listLugar) {
			listDtoLugar.add(construirDTO(lugar));
		}
		return listDtoLugar;
	}

	private List<Lugar> mapearListaADominio(List<LugarEntidad> lugarEntidadList) {
		return lugarEntidadList.stream().map(a -> mapearADominio(a)).collect(Collectors.toCollection(ArrayList::new));
	}

	public LugarEntidad consultarLugarPorId(Long id) {
		LugarEntidad lugarEntidad = new LugarEntidad();
		mapperDozer.map(lugarRepository.findByCodigoLugar(id), lugarEntidad);
		return lugarEntidad;
	}

	public DTOLugar consultarLugarXId(Long codigoLugar) {
		return construirDTO(mapearADominio(lugarRepository.findByCodigoLugar(codigoLugar)));
	}

	@Override
	protected DTOLugar construirDTO(Object object) {
		Lugar lugar = (Lugar) object;
		DTOLugar dtoLugar = new DTOLugar();
		dtoLugar.setCodigoLugar(lugar.getCodigoLugar());
		dtoLugar.setNombre(lugar.getNombre());
		dtoLugar.setUbicacion(lugar.getUbicacion());
		dtoLugar.setUsuario(controladorDatosUsuario.consultarPorCedula(lugar.getCodigoUsuario()));
		return dtoLugar;
	}

	@Override
	public Lugar construirDominio(Object object) {
		DTOLugar dtoLugar = (DTOLugar) object;
		Lugar lugar = new Lugar();
		lugar.setCodigoLugar(dtoLugar.getCodigoLugar());
		lugar.setNombre(dtoLugar.getNombre());
		lugar.setUbicacion(dtoLugar.getUbicacion());
		lugar.setCodigoUsuario(dtoLugar.getUsuario().getCedula());
		return lugar;
	}

	@Override
	protected Lugar mapearADominio(Object object) {
		LugarEntidad lugarEntidad = (LugarEntidad) object;
		return mapperDozer.map(lugarEntidad, Lugar.class);
	}

	@Override
	protected LugarEntidad mapearAEntidad(Object object) {
		Lugar lugar = (Lugar) object;
		return mapperDozer.map(lugar, LugarEntidad.class);
	}

	@Transactional
	@Override
	public void guardar(Object object) {
		Lugar lugar = (Lugar) object;
		lugarRepository.save(mapearAEntidad(lugar));
	}

	@Transactional
	public void eliminarLugar(Long codigoLugar) {
		List<ParcelaEntidad> lugaresAsociados = parcelaRepository.findByCodigoLugar(codigoLugar);
		if (!lugaresAsociados.isEmpty())
			throw new ExcepcionClaveForanea(MensajesConstantes.ERROR_ASOCIACION_USUARIO);
		lugarRepository.deleteById(codigoLugar);
	}
}
