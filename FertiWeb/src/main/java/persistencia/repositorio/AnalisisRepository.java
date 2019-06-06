package persistencia.repositorio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import persistencia.entidad.AnalisisEntidad;

public interface AnalisisRepository extends JpaRepository<AnalisisEntidad, Long> {

	AnalisisEntidad findByCodigoAnalisis(Long codigoAnalisis);

	List<AnalisisEntidad> findByCodigoParcelaIn(List<Long> codigos);

	List<AnalisisEntidad> findByCodigoParcela(Long codigo);

	@Query(value = "SELECT A.* " + "	FROM LUGAR L, PARCELA P , ANALISIS A"
			+ "	WHERE P.PAR_CODIGO_LUGAR = L.LUG_CODIGO " + "	AND A.ANA_COD_PARCELA = P.PAR_CODIGO "
			+ "	AND L.LUG_CODIGO_USUARIO = ?1 " + "	ORDER BY A.ANA_FECHA_ANALISIS DESC", nativeQuery = true)
	List<AnalisisEntidad> findAllByCodigoUsuario(Long codigoUSuario);

	@Query(value = "SELECT A.* " + "	FROM LUGAR L, PARCELA P , ANALISIS A"
			+ "	WHERE P.PAR_CODIGO_LUGAR = L.LUG_CODIGO " + "	AND A.ANA_COD_PARCELA = P.PAR_CODIGO "
			+ "	AND L.LUG_CODIGO_USUARIO = ?1 " + "	ORDER BY A.ANA_FECHA_ANALISIS DESC", countQuery = "SELECT COUNT(*) "
					+ "	FROM LUGAR L, PARCELA P , ANALISIS A" + "	WHERE P.PAR_CODIGO_LUGAR = L.LUG_CODIGO "
					+ "	AND A.ANA_COD_PARCELA = P.PAR_CODIGO " + "	AND L.LUG_CODIGO_USUARIO = ?1 ", nativeQuery = true)
	Page<AnalisisEntidad> findAllByCodigoUsuario(Long codigoUSuario, Pageable paginador);

	@Query(value = "SELECT A.* " + "	FROM PARCELA P, ANALISIS A"
			+ "	WHERE P.PAR_CODIGO_LUGAR = (SELECT L.LUG_CODIGO FROM LUGAR L WHERE(L.LUG_NOMBRE LIKE %?1% OR L.LUG_UBICACION LIKE %?1%)) "
			+ "	AND A.ANA_COD_PARCELA = P.PAR_CODIGO "
			+ "	ORDER BY A.ANA_FECHA_ANALISIS DESC", countQuery = "SELECT COUNT(*) " + "	FROM PARCELA P, ANALISIS A"
					+ "	WHERE P.PAR_CODIGO_LUGAR = (SELECT L.LUG_CODIGO FROM LUGAR L WHERE(L.LUG_NOMBRE LIKE %?1% OR L.LUG_UBICACION LIKE %?1%)) "
					+ "	AND A.ANA_COD_PARCELA = P.PAR_CODIGO ", nativeQuery = true)
	Page<AnalisisEntidad> findAllLikeLugarNombreUbicacion(String filtro, Pageable paginador);

	Page<AnalisisEntidad> findByCodigoParcela(long codigoParcela, Pageable paginador);

	@Query(value = "select distinct a.* from analisis a where a.ana_cod_parcela in (select p.par_codigo from parcela p, lugar l where p.par_codigo_lugar = l.lug_codigo and l.lug_codigo_usuario = ?1)", nativeQuery = true)
	List<AnalisisEntidad> findAllByCodigoUsuarioParaApp(Long codigoUsuario);
}
