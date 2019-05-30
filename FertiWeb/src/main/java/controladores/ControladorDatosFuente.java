package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import constantes.MensajesConstantes;
import dominio.Fuente;
import dto.DTOFuente;
import excepciones.ExcepcionClaveForanea;
import persistencia.entidad.FuenteEntidad;
import persistencia.repositorio.FuenteRepository;
import persistencia.repositorio.FuenteXRecomendacionRepository;

public class ControladorDatosFuente extends ControladorDatos {

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private FuenteRepository fuenteRepository;

	@Autowired
	private FuenteXRecomendacionRepository fuenteXRecomendacionRepository;

	@Autowired
	private ControladorDatosTipoFuente controladorDatosTipoFuente;

	public List<DTOFuente> consultarFuentes() {
		List<Fuente> fuentes = mapearListaADominio(fuenteRepository.findAll());
		return construirListaDTO(fuentes);
	}

	public DTOFuente consultarFuenteXId(Long codigoFuente) {
		return construirDTO(mapearADominio(fuenteRepository.findBycodigoFuente(codigoFuente)));
	}

	public List<DTOFuente> consultarFuentesParaNitrogeno() {
		List<Fuente> fuentes = mapearListaADominio(fuenteRepository.findAllByNitrogeno());
		return construirListaDTO(fuentes);
	}

	public List<DTOFuente> consultarFuentesParaFosforo() {
		List<Fuente> fuentes = mapearListaADominio(fuenteRepository.findAllByFosforo());
		return construirListaDTO(fuentes);
	}

	public List<DTOFuente> consultarFuentesParaPotasio() {
		List<Fuente> fuentes = mapearListaADominio(fuenteRepository.findAllByPotasio());
		return construirListaDTO(fuentes);
	}

	private List<Fuente> mapearListaADominio(List<FuenteEntidad> fuenteEntidadList) {
		return fuenteEntidadList.stream().map(f -> mapearADominio(f)).collect(Collectors.toCollection(ArrayList::new));
	}

	protected List<DTOFuente> construirListaDTO(List<Fuente> listFuentes) {
		List<DTOFuente> listDtoFuentes = new ArrayList<>();
		for (Fuente fuente : listFuentes) {
			listDtoFuentes.add(construirDTO(fuente));
		}
		return listDtoFuentes;
	}

	@Override
	protected DTOFuente construirDTO(Object object) {
		Fuente fuente = (Fuente) object;
		DTOFuente dtoFuente = new DTOFuente();
		dtoFuente.setCodigoFuente(fuente.getCodigoFuente());
		dtoFuente.setEstado(fuente.isEstado());
		dtoFuente.setProducto(fuente.getProducto());
		dtoFuente.setTipoFuente(controladorDatosTipoFuente.consultarTipoFuenteXId(fuente.getCodigoTipoFuente()));
		return dtoFuente;
	}

	@Override
	public Fuente construirDominio(Object object) {
		DTOFuente dtoFuente = (DTOFuente) object;
		Fuente fuente = new Fuente();
		fuente.setCodigoFuente(dtoFuente.getCodigoFuente());
		fuente.setEstado(dtoFuente.isEstado());
		fuente.setProducto(dtoFuente.getProducto());
		fuente.setCodigoTipoFuente(dtoFuente.getTipoFuente().getCodigo());
		return fuente;
	}

	@Override
	protected Fuente mapearADominio(Object object) {
		FuenteEntidad fuenteEntidad = (FuenteEntidad) object;
		return mapperDozer.map(fuenteEntidad, Fuente.class);
	}

	@Override
	protected FuenteEntidad mapearAEntidad(Object object) {
		Fuente fuente = (Fuente) object;
		return mapperDozer.map(fuente, FuenteEntidad.class);
	}

	@Transactional
	@Override
	public void guardar(Object object) {
		Fuente fuente = (Fuente) object;
		fuenteRepository.save(mapearAEntidad(fuente));
	}

	@Transactional
	public void eliminarFuente(long codigoFuente) {
		if (fuenteXRecomendacionRepository.findFirstByCodigoFuente(codigoFuente) != null)
			throw new ExcepcionClaveForanea(MensajesConstantes.ERROR_ASOCIACION_FUENTE_X_RECOMENDACION);
		fuenteRepository.deleteById(codigoFuente);
	}

}
