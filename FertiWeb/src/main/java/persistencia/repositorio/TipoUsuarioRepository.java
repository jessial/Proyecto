package persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import persistencia.entidad.TipoUsuarioEntidad;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuarioEntidad, Integer> {

}
