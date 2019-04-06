package persistencia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import persistencia.entidad.LugarEntidad;

public interface LugarRepository extends JpaRepository<LugarEntidad, Long> {

	List<LugarEntidad> findByCodigoUsuario(Long cedula);

	LugarEntidad findByCodigoLugar(Long codigoLugar);

}
