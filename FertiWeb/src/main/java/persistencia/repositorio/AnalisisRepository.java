package persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import persistencia.entidad.AnalisisEntidad;

public interface AnalisisRepository extends JpaRepository<AnalisisEntidad, Long> {

}
