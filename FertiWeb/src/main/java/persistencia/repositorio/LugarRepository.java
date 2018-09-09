package persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import persistencia.entidad.LugarEntidad;

public interface LugarRepository extends JpaRepository<LugarEntidad, Long> {

}
