package controladores;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import constantes.MensajesConstantes;
import dominio.Usuario;
import dominio.UsuarioSeguridad;
import excepciones.ExcepcionSeguridad;
import persistencia.entidad.UsuarioSeguridadEntidad;
import persistencia.repositorio.UsuarioSeguridadRepository;
import utilidades.ServicioEnvioCorreos;

@Service
public class ControladorSeguridad implements UserDetailsService {

	@Autowired
	UsuarioSeguridadRepository usuarioRepository;

	@Autowired
	ControladorDatosRol controladorDatosRol;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private ControladorDatosUsuario controladorDatosUsuario;


	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UsuarioSeguridadEntidad usuarioEntidad = usuarioRepository.findByNombreUsuario(username);

		if (usuarioEntidad == null) {
			throw new UsernameNotFoundException(username);
		}

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(
				controladorDatosRol.consultarRolPorCodigo(usuarioEntidad.getCodigorol()).getTipoRol()));
		return new User(usuarioEntidad.getNombreUsuario(), usuarioEntidad.getPassword(), usuarioEntidad.isEstado(),
				true, true, true, authorities);
	}

	public void guardarUsuario(UsuarioSeguridad usuario) {
		usuarioRepository.save(convertirAEntidad(usuario));
	}

	private UsuarioSeguridadEntidad convertirAEntidad(UsuarioSeguridad usuario) {
		UsuarioSeguridadEntidad usuarioEntidad = new UsuarioSeguridadEntidad();
		usuarioEntidad.setNombreUsuario(usuario.getNombreUsuario());
		usuarioEntidad.setPassword(passwordEncoder.encode(usuario.getPassword()));
		usuarioEntidad.setEstado(usuario.isEstado());
		usuarioEntidad.setCodigorol(usuario.getRol().getCodigo());
		return usuarioEntidad;
	}

	public void guardarUsuario(UsuarioSeguridadEntidad usuario) {
		usuarioRepository.save(usuario);
	}

	public void cambiarClave(Long cedula) {
		String stringCodigoUsuario = (Long.toString(cedula));
		UsuarioSeguridadEntidad usuarioEntidad = usuarioRepository.findByNombreUsuario(stringCodigoUsuario);
		if (usuarioEntidad == null) {
			throw new ExcepcionSeguridad(MessageFormat
					.format(MensajesConstantes.ERROR_RECUPERANDO_USUARIO_NO_ENCONTRADO, stringCodigoUsuario));
		}
		Usuario usuario = controladorDatosUsuario.consultarPorCedula(cedula);
		try {
			ServicioEnvioCorreos.EnviarCorreoSG.enviarCorreo(usuario.getEmail(), usuario.getPassword());
		} catch (IOException e) {
			throw new ExcepcionSeguridad(MensajesConstantes.ERROR_ENVIANDO_CORREO);
		}
	}

}
