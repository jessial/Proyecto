package persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import persistencia.entidad.FuenteEntidad;

public interface FuenteRepository extends JpaRepository<FuenteEntidad, Long> {

}
