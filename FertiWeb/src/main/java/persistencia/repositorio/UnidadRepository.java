package persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import persistencia.entidad.UnidadEntidad;

public interface UnidadRepository extends JpaRepository<UnidadEntidad, Long> {

	UnidadEntidad findByCodigoUnidad(Long codigoUnidad);

}
