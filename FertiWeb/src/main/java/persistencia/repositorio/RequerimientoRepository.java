package persistencia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dto.RequerimientoPorCultivo;
import persistencia.entidad.RequerimientoEntidad;

public interface RequerimientoRepository extends JpaRepository<RequerimientoEntidad, Long> {
	
	List<RequerimientoPorCultivo> getTodos();

}
