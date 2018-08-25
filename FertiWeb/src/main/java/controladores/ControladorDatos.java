package controladores;

import java.util.List;

import org.dozer.DozerBeanMapper;

import org.springframework.beans.factory.annotation.Autowired;

import dominio.Analisis;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import persistencia.entidad.AnalisisEntidad;
import persistencia.entidad.RolEntidad;
import persistencia.repositorio.AnalisisRepository;
import persistencia.repositorio.RolRepository;

@AllArgsConstructor
@NoArgsConstructor
public class ControladorDatos {
	
	@Autowired
	private DozerBeanMapper mapperDozer;
	
	@Autowired
	private AnalisisRepository analisisRepository;
	
	@Autowired
	private RolRepository rolRepository;
	
	

	public void guardarAnalisis(Analisis analisisSuelo) {
		AnalisisEntidad analisisEntidad = new AnalisisEntidad();
		mapperDozer.map(analisisSuelo, analisisEntidad);
		analisisRepository.save(analisisEntidad);
	}

	public List<RolEntidad> consultarRoles() {
		return rolRepository.findAll();
	}
	
}
