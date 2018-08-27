package controladores;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.Analisis;
import dominio.Rol;
import dominio.TipoCultivo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import persistencia.entidad.AnalisisEntidad;
import persistencia.entidad.TipoCultivoEntidad;
import persistencia.repositorio.AnalisisRepository;
import persistencia.repositorio.RolRepository;
import persistencia.repositorio.TipoCultivoRepository;


@AllArgsConstructor
@NoArgsConstructor
public class ControladorDatos {
	
	@Autowired
	private DozerBeanMapper mapperDozer;
	
	@Autowired
	private AnalisisRepository analisisRepository;
	
	@Autowired
	private RolRepository rolRepository;
	
	@Autowired
	private TipoCultivoRepository tipoCultivoRepository;
	
	

	public void guardarAnalisis(Analisis analisisSuelo) {
		AnalisisEntidad analisisEntidad = new AnalisisEntidad();
		mapperDozer.map(analisisSuelo, analisisEntidad);
		analisisRepository.save(analisisEntidad);
	}

	public List<Rol> consultarRoles() {
		List<Rol> roles = new ArrayList<>();
		mapperDozer.map(roles, rolRepository.findAll());
		return roles;
	}

	public List<TipoCultivoEntidad> consultarTiposCultivo() {
		List<TipoCultivo> tiposCultivo = new ArrayList<>();
		List<TipoCultivoEntidad> tiposCultivoEntidad = tipoCultivoRepository.findAll();
		mapperDozer.map(tiposCultivo, tiposCultivoEntidad);
		return tiposCultivoEntidad;
	}

	public void guardarTipoCultivo(TipoCultivo tipoCultivo) {
		TipoCultivoEntidad tipoCultivoEntidad = new TipoCultivoEntidad();
		mapperDozer.map(tipoCultivo, tipoCultivoEntidad);
		tipoCultivoRepository.save(tipoCultivoEntidad);	
	}
	
}
