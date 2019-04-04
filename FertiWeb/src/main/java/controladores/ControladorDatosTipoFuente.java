package controladores;

import java.util.ArrayList;
import java.util.List;

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
	private TipoFuenteRepository tipoFuenteRepository;

	@Autowired
	private ControladorDatosUnidad controladorDatosUnidad;

	public List<TipoFuente> consultarTipoFuentes() {
		List<TipoFuente> fuentesModelo = new ArrayList<>();
		List<TipoFuenteEntidad> fuentesEntidad = tipoFuenteRepository.findAll();
		fuentesEntidad.forEach(fuente -> {
			UnidadEntidad unidadEntidad = controladorDatosUnidad.consultarUnidadPorId(fuente.getUnidad());
			fuentesModelo.add(convertirTipoFuenteAModelo(fuente, unidadEntidad));
		});
		return fuentesModelo;
	}

	public void guardarTipoFuente(TipoFuente tipoFuente) {
		tipoFuenteRepository.save(convertirTipoFuenteAEntidad(tipoFuente));
	}

	public void eliminarTipoFuente(long codigo) {
		tipoFuenteRepository.deleteById(codigo);
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
