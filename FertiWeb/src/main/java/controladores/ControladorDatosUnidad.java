package controladores;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.Unidad;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import persistencia.entidad.UnidadEntidad;
import persistencia.repositorio.UnidadRepository;

@AllArgsConstructor
@NoArgsConstructor
public class ControladorDatosUnidad {

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private UnidadRepository unidadRepository;

	public UnidadEntidad consultarUnidadPorId(Long id) {
		UnidadEntidad unidadEntidad = new UnidadEntidad();
		mapperDozer.map(unidadRepository.findByCodigoUnidad(id), unidadEntidad);
		return unidadEntidad;
	}

	public List<Unidad> consultarUnidad() {
		List<Unidad> unidad = new ArrayList<>();
		mapperDozer.map(unidadRepository.findAll(), unidad);
		return unidad;
	}
}
