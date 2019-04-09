package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dominio.TipoFuente;
import dto.DTOTipoFuente;
import persistencia.entidad.TipoFuenteEntidad;
import persistencia.repositorio.TipoFuenteRepository;

public class ControladorDatosTipoFuente extends ControladorDatos{

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private TipoFuenteRepository tipoFuenteRepository;

	@Autowired
	private ControladorDatosUnidad controladorDatosUnidad;

	public List<DTOTipoFuente> consultarTipoFuentes() {
		List<TipoFuente> listTipoFuente = mapearListaADominio(tipoFuenteRepository.findAll());
		return construirListaDTO(listTipoFuente);
	}

	private List<TipoFuente> mapearListaADominio(List<TipoFuenteEntidad> listTipoFuenteEntidad) {
		return listTipoFuenteEntidad.stream().map(a -> mapearADominio(a))
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	protected List<DTOTipoFuente> construirListaDTO(List<TipoFuente> listTipoFuente) {
		List<DTOTipoFuente> listDTOTipoFuente = new ArrayList<>();
		for (TipoFuente tipoFuente : listTipoFuente) {
			listDTOTipoFuente.add(construirDTO(tipoFuente));
		}
		return listDTOTipoFuente;
	}

	public TipoFuente consultarTipoFuenteXId(Long codigoTipoFuente) {
		return mapearADominio(tipoFuenteRepository.findByCodigo(codigoTipoFuente));
	}

	@Override
	protected DTOTipoFuente construirDTO(Object object) {
		TipoFuente tipoFuente = (TipoFuente) object;
		DTOTipoFuente dtoTipoFuente = new DTOTipoFuente();
		dtoTipoFuente.setAporte(tipoFuente.getAporte());
		dtoTipoFuente.setCodigo(tipoFuente.getCodigo());
		dtoTipoFuente.setEstado(tipoFuente.isEstado());
		dtoTipoFuente.setNombre(tipoFuente.getNombre());
		dtoTipoFuente.setUnidad(controladorDatosUnidad.consultarUnidadXId(tipoFuente.getUnidad()));
		return dtoTipoFuente;
	}
	
	@Override
	public TipoFuente construirDominio(Object object) {
		DTOTipoFuente dtoTipoFuente = (DTOTipoFuente) object;
		TipoFuente tipoFuente = new TipoFuente();
		tipoFuente.setAporte(dtoTipoFuente.getAporte());
		tipoFuente.setCodigo(dtoTipoFuente.getCodigo());
		tipoFuente.setEstado(dtoTipoFuente.getEstado());
		tipoFuente.setNombre(dtoTipoFuente.getNombre());
		tipoFuente.setUnidad(dtoTipoFuente.getUnidad().getCodigoUnidad());
		return tipoFuente;
	}

	@Override
	protected TipoFuente mapearADominio(Object object) {
		TipoFuenteEntidad tipoFuenteEntidad = (TipoFuenteEntidad) object;
		return mapperDozer.map(tipoFuenteEntidad, TipoFuente.class);
	}

	@Override
	protected TipoFuenteEntidad mapearAEntidad(Object object) {
		TipoFuente tipoFuente = (TipoFuente) object;
		return mapperDozer.map(tipoFuente, TipoFuenteEntidad.class);
	}

	@Transactional
	@Override
	public void guardar(Object object) {
		TipoFuente tipoFuente = (TipoFuente) object;
		tipoFuenteRepository.save(mapearAEntidad(tipoFuente));
	}
	
	@Transactional
	public void eliminarTipoFuente(long codigo) {
		tipoFuenteRepository.deleteById(codigo);
	}

}
