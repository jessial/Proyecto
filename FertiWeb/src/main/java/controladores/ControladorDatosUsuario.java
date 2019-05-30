package controladores;

import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.Usuario;
import dominio.UsuarioSeguridad;
import excepciones.ExcepcionUsuarioDuplicado;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import persistencia.entidad.UsuarioEntidad;
import persistencia.repositorio.UsuarioRepository;

@AllArgsConstructor
@NoArgsConstructor
public class ControladorDatosUsuario {

	private static final String MENSAJE_ERROR = "El usuario %l ya se encuentra registrado";

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ControladorSeguridad controladorSeguridad;
	
	@Autowired
	ControladorDatosRol controladorDatosRol;

	public Usuario consultarPorCedula(Long cedula) {
		Usuario usuario = new Usuario();
		mapperDozer.map(
				Optional.ofNullable(usuarioRepository.findFirstByCedula(cedula)).orElseGet(() -> new UsuarioEntidad()),
				usuario);
		return usuario;
	}

	public void guardarUsuarioNuevo(Usuario usuario) throws ExcepcionUsuarioDuplicado {
		UsuarioEntidad usuarioEntidad = new UsuarioEntidad();
		if (usuarioNoExiste(usuario.getCedula())) {
			mapperDozer.map(usuario, usuarioEntidad);
			usuarioRepository.save(usuarioEntidad);
			crearUsuarioSeguridad(usuario);
		} else {
			throw new ExcepcionUsuarioDuplicado(String.format(MENSAJE_ERROR, usuario.getCedula()));
		}

	}

	private void crearUsuarioSeguridad(Usuario usuario) {
		UsuarioSeguridad usuarioSeguridad = new UsuarioSeguridad();
		usuarioSeguridad.setNombreUsuario(usuario.getCedula().toString());
		usuarioSeguridad.setPassword(usuario.getPassword());
		usuarioSeguridad.setRol(controladorDatosRol.consultarRolPorCodigo(usuario.getCodigoRol()));
		usuarioSeguridad.setEstado(true);
		controladorSeguridad.guardarUsuario(usuarioSeguridad);
	}

	public boolean usuarioNoExiste(Long cedula) {
		UsuarioEntidad usuario = usuarioRepository.findFirstByCedula(cedula);
		return null == usuario;
	}

}
