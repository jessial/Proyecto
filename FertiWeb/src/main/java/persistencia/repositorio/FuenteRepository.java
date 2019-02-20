package persistencia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import persistencia.entidad.FuenteEntidad;

public interface FuenteRepository extends JpaRepository<FuenteEntidad, Long> {

	public List getTodos();

}
