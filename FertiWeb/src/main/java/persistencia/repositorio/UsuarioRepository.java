package persistencia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import persistencia.entidad.UsuarioEntidad;

public interface UsuarioRepository extends JpaRepository<UsuarioEntidad, Long> {

	UsuarioEntidad findFirstByCedula(Long cedula);

	List<UsuarioEntidad> findByCodigoRol(Long codigoRol);
}
