package controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import persistencia.entidad.UsuarioSeguridadEntidad;
import persistencia.repositorio.UsuarioSeguridadRepository;

@Service
public class ControladorSeguridad implements UserDetailsService{

	@Autowired
	UsuarioSeguridadRepository usuarioRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UsuarioSeguridadEntidad usuarioEntidad = usuarioRepository.findByNombreUsuario(username);
		return new User(usuarioEntidad.getNombreUsuario(), usuarioEntidad.getPassword(), usuarioEntidad.isEstado(),
				true, true, true, null);
	}

}
