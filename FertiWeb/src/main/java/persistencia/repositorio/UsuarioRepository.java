package persistencia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import persistencia.entidad.UsuarioEntidad;

public interface UsuarioRepository extends JpaRepository<UsuarioEntidad, Long> {

	List<UsuarioEntidad> findByCedula(Long cedula);
}
