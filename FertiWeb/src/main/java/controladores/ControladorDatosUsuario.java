package controladores;

import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.Usuario;
import dominio.UsuarioSeguridad;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import persistencia.entidad.UsuarioEntidad;
import persistencia.repositorio.UsuarioRepository;

@AllArgsConstructor
@NoArgsConstructor
public class ControladorDatosUsuario {

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ControladorSeguridad controladorSeguridad;

	public Usuario consultarPorCedula(Long cedula) {
		Usuario usuario = new Usuario();
		mapperDozer.map(Optional.ofNullable(usuarioRepository.findByCedula(cedula).get(0))
				.orElseGet(() -> new UsuarioEntidad()), usuario);
		return usuario;
	}

	public void guardarUsuarioNuevo(Usuario usuario) {
		UsuarioEntidad usuarioEntidad = new UsuarioEntidad();
		if (usuarioExisteEnBd(usuario.getCedula())) {
			mapperDozer.map(usuario, usuarioEntidad);
			usuarioRepository.save(usuarioEntidad);
			crearUsuarioSeguridad(usuario);
		}

	}

	private void crearUsuarioSeguridad(Usuario usuario) {
		UsuarioSeguridad usuarioSeguridad = new UsuarioSeguridad();
		usuarioSeguridad.setNombreUsuario(usuario.getCedula().toString());
		usuarioSeguridad.setPassword(usuario.getPassword());
		usuarioSeguridad.setEstado(true);
		controladorSeguridad.guardarUsuario(usuarioSeguridad);
	}

	public boolean usuarioExisteEnBd(Long cedula) {
		return null != usuarioRepository.findByCedula(cedula);
	}

}
