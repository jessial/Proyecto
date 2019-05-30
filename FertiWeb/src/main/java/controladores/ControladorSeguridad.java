package controladores;

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

import dominio.UsuarioSeguridad;
import persistencia.entidad.UsuarioSeguridadEntidad;
import persistencia.repositorio.UsuarioSeguridadRepository;

@Service
public class ControladorSeguridad implements UserDetailsService {

	@Autowired
	UsuarioSeguridadRepository usuarioRepository;

	@Autowired
	ControladorDatosRol controladorDatosRol;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UsuarioSeguridadEntidad usuarioEntidad = usuarioRepository.findByNombreUsuario(username);

		if (usuarioEntidad == null) {
			throw new UsernameNotFoundException(username);
		}

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(controladorDatosRol.consultarRolPorCodigo(usuarioEntidad.getCodigorol()).getTipoRol()));
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

}
