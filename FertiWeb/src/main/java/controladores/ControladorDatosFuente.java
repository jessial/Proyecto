package controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dominio.Fuente;
import dominio.TipoFuente;
import dominio.Unidad;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import persistencia.entidad.FuenteEntidad;
import persistencia.entidad.TipoFuenteEntidad;
import persistencia.entidad.UnidadEntidad;
import persistencia.repositorio.FuenteRepository;

@AllArgsConstructor
@NoArgsConstructor
public class ControladorDatosFuente {

	@Autowired
	private FuenteRepository fuenteRepository;

	@Autowired
	private ControladorDatosTipoFuente controladorDatosTipoFuente;

	@Autowired
	private ControladorDatosUnidad controladorDatosUnidad;

	public List<Fuente> consultarFuentes() {
		List<Fuente> fuentesModelo = new ArrayList<>();
		List<FuenteEntidad> fuentesEntidad = fuenteRepository.findAll();
		fuentesEntidad.forEach(fuente -> {
			TipoFuenteEntidad tipoFuenteEntidad = controladorDatosTipoFuente
					.consultarTipoFuentePorId(fuente.getCodigoTipoFuente());
			UnidadEntidad unidadEntidad = controladorDatosUnidad.consultarUnidadPorId(tipoFuenteEntidad.getUnidad());
			fuentesModelo.add(convertirFuenteAModelo(fuente, tipoFuenteEntidad, unidadEntidad));
		});
		return fuentesModelo;
	}

	public void guardarFuente(Fuente fuente) {
		fuenteRepository.save(convertirFuenteAEntidad(fuente));
	}

	public void eliminarFuente(long codigoFuente) {
		fuenteRepository.deleteById(codigoFuente);
	}

	private Fuente convertirFuenteAModelo(FuenteEntidad fuenteEntidad, TipoFuenteEntidad tipoFuenteEntidad,
			UnidadEntidad unidadEntidad) {
		Unidad unidadDominio = new Unidad(unidadEntidad.getCodigoUnidad(), unidadEntidad.getNombreUnidad());
		TipoFuente tipoFuenteDominio = new TipoFuente(tipoFuenteEntidad.getCodigo(), tipoFuenteEntidad.getNombre(),
				tipoFuenteEntidad.getAporte(), unidadDominio, tipoFuenteEntidad.isEstado());

		return new Fuente(fuenteEntidad.getCodigoFuente(), tipoFuenteDominio, fuenteEntidad.getProducto(),
				fuenteEntidad.isEstado());
	}

	private FuenteEntidad convertirFuenteAEntidad(Fuente fuente) {
		return new FuenteEntidad(fuente.getCodigoFuente(), fuente.getTipoFuente().getCodigo(), fuente.getProducto(),
				fuente.isEstado());
	}

}
