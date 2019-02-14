package persistencia.repositorio;

import org.springframework.data.repository.CrudRepository;

import persistencia.entidad.UsuarioSeguridadEntidad;

public interface UsuarioSeguridadRepository extends CrudRepository<UsuarioSeguridadEntidad, Long> {
	
	UsuarioSeguridadEntidad findByNombreUsuario(String nombreUsuario);

}
