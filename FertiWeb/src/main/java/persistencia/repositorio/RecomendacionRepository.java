package persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import persistencia.entidad.RecomendacionEntidad;

public interface RecomendacionRepository extends JpaRepository<RecomendacionEntidad, Long> {

}
