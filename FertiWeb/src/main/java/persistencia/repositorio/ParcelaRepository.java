package persistencia.repositorio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import persistencia.entidad.ParcelaEntidad;

public interface ParcelaRepository extends JpaRepository<ParcelaEntidad, Long> {

	List<ParcelaEntidad> findByCodigoParcelaIn(List<Long> codigos);

	List<ParcelaEntidad> findByCodigoLugar(Long codigoLugar);

	ParcelaEntidad findByCodigoParcela(Long codigoParcela);

	List<ParcelaEntidad> findByCodigoCultivoSembrado(Long codigoTipoCultivo);

	@Query(value = "select p.* from parcela p, lugar l where p.par_codigo_lugar = l.lug_codigo and l.lug_codigo_usuario = ?1", nativeQuery = true)
	List<ParcelaEntidad> findAllByCodigoUsuario(Long codigoUsuario);

	@Query(value = "select p.* from parcela p, lugar l, usuario u where p.par_codigo_lugar = l.lug_codigo and l.lug_codigo_usuario = u.usu_cedula and u.usu_nombre like %?1%", countQuery = "select count(*) from parcela p, lugar l, usuario u where p.par_codigo_lugar = l.lug_codigo and l.lug_codigo_usuario = u.usu_cedula and u.usu_nombre like %?1%", nativeQuery = true)
	Page<ParcelaEntidad> findAllLikeUsuarioNombre(String filtro, Pageable paginador);
	
	@Query(value = "SELECT P.* FROM PARCELA P, LUGAR L, USUARIO U WHERE P.PAR_CODIGO_LUGAR = L.LUG_CODIGO AND L.LUG_CODIGO_USUARIO = U.USU_CEDULA ORDER BY U.USU_APELLIDO ASC, U.USU_NOMBRE ASC", countQuery = "SELECT COUNT(*) FROM PARCELA P, LUGAR L, USUARIO U WHERE P.PAR_CODIGO_LUGAR = L.LUG_CODIGO AND L.LUG_CODIGO_USUARIO = U.USU_CEDULA ORDER BY U.USU_APELLIDO ASC, U.USU_NOMBRE ASC", nativeQuery = true)
	Page<ParcelaEntidad> findAllOrderByUsuario(Pageable paginador);

}
