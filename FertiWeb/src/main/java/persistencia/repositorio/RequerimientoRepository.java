package persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import persistencia.entidad.RequerimientoEntidad;

public interface RequerimientoRepository extends JpaRepository<RequerimientoEntidad, Long> {

}
