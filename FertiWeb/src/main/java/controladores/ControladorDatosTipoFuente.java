package controladores;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.TipoFuente;
import dominio.Unidad;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import persistencia.entidad.TipoFuenteEntidad;
import persistencia.entidad.UnidadEntidad;
import persistencia.repositorio.TipoFuenteRepository;

@AllArgsConstructor
@NoArgsConstructor
public class ControladorDatosTipoFuente {

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private TipoFuenteRepository tipoFuenteRepository;

	@Autowired
	private ControladorDatosUnidad controladorDatosUnidad;

	public List<TipoFuente> consultarTipoFuentes() {
		List<TipoFuente> tipoFuentesModelo = new ArrayList<>();
		List<TipoFuenteEntidad> tipoFuenteEntidad = tipoFuenteRepository.findAll();
		tipoFuenteEntidad.forEach(fuente -> {
			UnidadEntidad unidadEntidad = controladorDatosUnidad.consultarUnidadPorId(fuente.getUnidad());
			tipoFuentesModelo.add(convertirTipoFuenteAModelo(fuente, unidadEntidad));
		});
		return tipoFuentesModelo;
	}

	public void guardarTipoFuente(TipoFuente tipoFuente) {
		tipoFuenteRepository.save(convertirTipoFuenteAEntidad(tipoFuente));
	}

	public void eliminarTipoFuente(long codigo) {
		tipoFuenteRepository.deleteById(codigo);
	}

	public TipoFuenteEntidad consultarTipoFuentePorId(Long id) {
		TipoFuenteEntidad tipoFuenteEntidad = new TipoFuenteEntidad();
		mapperDozer.map(tipoFuenteRepository.findByCodigo(id), tipoFuenteEntidad);
		return tipoFuenteEntidad;
	}

	private TipoFuente convertirTipoFuenteAModelo(TipoFuenteEntidad tipoFuenteEntidad, UnidadEntidad unidadEntidad) {
		Unidad unidadDominio = new Unidad(unidadEntidad.getCodigoUnidad(), unidadEntidad.getNombreUnidad());
		return new TipoFuente(tipoFuenteEntidad.getCodigo(), tipoFuenteEntidad.getNombre(),
				tipoFuenteEntidad.getAporte(), unidadDominio, tipoFuenteEntidad.isEstado());
	}

	private TipoFuenteEntidad convertirTipoFuenteAEntidad(TipoFuente tipoFuente) {
		return new TipoFuenteEntidad(tipoFuente.getCodigo(), tipoFuente.getNombre(), tipoFuente.getAporte(),
				tipoFuente.getUnidad().getCodigoUnidad(), tipoFuente.getEstado());
	}
}
