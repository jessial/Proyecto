package persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import persistencia.entidad.UsuarioEntidad;

public interface UsuarioRepository extends JpaRepository<UsuarioEntidad, Long> {

}
