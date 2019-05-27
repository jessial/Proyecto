package persistencia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import persistencia.entidad.RecomendacionEntidad;

public interface RecomendacionRepository extends JpaRepository<RecomendacionEntidad, Long> {

	List<RecomendacionEntidad> findBycodigoAnalisis(Long codigo);

}
