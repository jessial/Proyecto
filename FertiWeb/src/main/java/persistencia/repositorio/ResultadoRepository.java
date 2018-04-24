package persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import persistencia.entidad.ResultadoEntidad;

public interface ResultadoRepository extends JpaRepository<ResultadoEntidad, Integer> {

}
