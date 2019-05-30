package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import constantes.MensajesConstantes;
import dominio.Rol;
import excepciones.ExcepcionClaveForanea;
import persistencia.entidad.RolEntidad;
import persistencia.entidad.UsuarioEntidad;
import persistencia.repositorio.RolRepository;
import persistencia.repositorio.UsuarioRepository;

public class ControladorDatosRol extends ControladorDatos {

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private RolRepository rolRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Cacheable("GlobalCacheConstant.CACHE_ROLES")
	public List<Rol> consultarRoles() {
		return mapearListaADominio(rolRepository.findAll());
	}

	@Cacheable("GlobalCacheConstant.CACHE_ROLES_APP")
	public List<Rol> consultarRolesParaApp() {
		boolean estado = true;
		return mapearListaADominio(rolRepository.findByEstado(estado));
	}

	@Cacheable("GlobalCacheConstant.CACHE_ROL")
	public Rol consultarRolPorCodigo(Long codigoRol) {
		Rol rol = new Rol();
		mapperDozer.map(rolRepository.findFirstByCodigo(codigoRol), rol);
		return rol;
	}

	private List<Rol> mapearListaADominio(List<RolEntidad> rolEntidadList) {
		return rolEntidadList.stream().map(a -> mapearADominio(a)).collect(Collectors.toCollection(ArrayList::new));
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
	@CacheEvict(value = { "GlobalCacheConstant.CACHE_ROL", "GlobalCacheConstant.CACHE_ROLES_APP",
			"GlobalCacheConstant.CACHE_ROLES" }, allEntries = true)
	public void guardar(Object object) {
		Rol rol = (Rol) object;
		rolRepository.save(mapearAEntidad(rol));
	}

	@Transactional
	@CacheEvict(value = { "GlobalCacheConstant.CACHE_ROL", "GlobalCacheConstant.CACHE_ROLES_APP",
			"GlobalCacheConstant.CACHE_ROLES" }, allEntries = true)
	public void eliminarRol(long codigoRol) {
		List<UsuarioEntidad> usuarios = usuarioRepository.findByCodigoRol(codigoRol);
		if (!usuarios.isEmpty())
			throw new ExcepcionClaveForanea(MensajesConstantes.ERROR_ASOCIACION_USUARIO);
		rolRepository.deleteById(codigoRol);
	}

}
