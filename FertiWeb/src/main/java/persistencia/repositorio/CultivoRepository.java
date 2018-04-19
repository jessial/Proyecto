package persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import persistencia.entidad.CultivoEntidad;

public interface CultivoRepository extends JpaRepository<CultivoEntidad, Long> {

}
