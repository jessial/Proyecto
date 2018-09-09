package persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import persistencia.entidad.RolEntidad;

public interface RolRepository extends JpaRepository<RolEntidad, Long> {

}
