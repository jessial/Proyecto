package persistencia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import persistencia.entidad.TipoFuenteEntidad;

public interface TipoFuenteRepository extends JpaRepository<TipoFuenteEntidad, Long> {

	public List getTodos();

}
