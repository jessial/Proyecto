package persistencia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import persistencia.entidad.AnalisisEntidad;

public interface AnalisisRepository extends JpaRepository<AnalisisEntidad, Long> {

	List<AnalisisEntidad> findByCodigoParcelaIn(List<Long> codigos);

	public List getTodos();

}
