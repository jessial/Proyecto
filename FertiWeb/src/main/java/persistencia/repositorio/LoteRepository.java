package persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import persistencia.entidad.LoteEntidad;

public interface LoteRepository extends JpaRepository<LoteEntidad, Long> {

}
