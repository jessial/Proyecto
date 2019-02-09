package persistencia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import persistencia.entidad.RolEntidad;

public interface RolRepository extends JpaRepository<RolEntidad, Long> {

	RolEntidad findByCodigo(Long codigoRol);

	List<RolEntidad> findByEstado(boolean estado);

}
