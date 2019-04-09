package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dominio.Rol;
import persistencia.entidad.RolEntidad;
import persistencia.repositorio.RolRepository;

public class ControladorDatosRol  extends ControladorDatos{

	@Autowired
	private DozerBeanMapper mapperDozer;
	
	@Autowired
	private RolRepository rolRepository;

	public List<Rol> consultarRoles() {
		return mapearListaADominio(rolRepository.findAll());
	}

	public List<Rol> consultarRolesParaApp() {
		boolean estado = true;
		return mapearListaADominio(rolRepository.findByEstado(estado));
	}

	public Rol consultarRolPorCodigo(Long codigoRol) {
		Rol rol = new Rol();
		mapperDozer.map(rolRepository.findByCodigo(codigoRol), rol);
		return rol;
	}
	
	private List<Rol> mapearListaADominio(List<RolEntidad> rolEntidadList) {
		return rolEntidadList.stream().map(a -> mapearADominio(a))
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	@Override
	protected Object construirDTO(Object object) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	protected Object construirDominio(Object object) {
		throw new UnsupportedOperationException();
	}

	@Override
	protected Rol mapearADominio(Object object) {
		RolEntidad rolEntidad = (RolEntidad) object;
		return mapperDozer.map(rolEntidad, Rol.class);
	}

	@Override
	protected RolEntidad mapearAEntidad(Object object) {
		Rol rol = (Rol) object;
		return mapperDozer.map(rol, RolEntidad.class);
	}

	@Transactional
	@Override
	public void guardar(Object object) {
		Rol rol = (Rol) object;
		rolRepository.save(mapearAEntidad(rol));
	}
	
	@Transactional
	public void eliminarRol(long codigoRol) {
		rolRepository.deleteById(codigoRol);
	}


}
