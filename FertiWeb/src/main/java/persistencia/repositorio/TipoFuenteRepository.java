package persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import persistencia.entidad.TipoFuenteEntidad;

public interface TipoFuenteRepository extends JpaRepository<TipoFuenteEntidad, Integer> {

}
