package controladores;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.Rol;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import persistencia.entidad.RolEntidad;
import persistencia.repositorio.RolRepository;

@AllArgsConstructor
@NoArgsConstructor
public class ControladorDatosRol {

	@Autowired
	private DozerBeanMapper mapperDozer;
	@Autowired
	private RolRepository rolRepository;

	// Consultar para front
	public List<Rol> consultarRoles() {
		List<Rol> roles = new ArrayList<>();
		mapperDozer.map(rolRepository.findAll(), roles);
		return roles;
	}

	// consultar para app
	public List<Rol> consultarRolesParaApp() {
		List<Rol> roles = new ArrayList<>();
		boolean estado = true;
		mapperDozer.map(rolRepository.findByEstado(estado), roles);
		return roles;
	}

	public Rol consultarRolPorCodigo(Long codigoRol) {
		Rol rol = new Rol();
		mapperDozer.map(rolRepository.findByCodigo(codigoRol), rol);
		return rol;
	}

	public void guardarRol(Rol rol) {
		RolEntidad rolEntidad = new RolEntidad();
		mapperDozer.map(rol, rolEntidad);
		rolRepository.save(rolEntidad);
	}

	public void eliminarRol(long codigoRol) {
		rolRepository.deleteById(codigoRol);
	}

}
