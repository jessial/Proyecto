package persistencia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import persistencia.entidad.ElementoXAnalisisEntidad;

public interface ElementoXAnalisisRepository extends JpaRepository<ElementoXAnalisisEntidad, Long>{

	List<ElementoXAnalisisEntidad> findBycodigoAnalisis(Long codigo);
}
