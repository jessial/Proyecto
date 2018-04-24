package persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import persistencia.entidad.AplicacionEntidad;

public interface AplicacionRepository extends JpaRepository<AplicacionEntidad, Integer> {

}
