package persistencia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import persistencia.entidad.AnalisisEntidad;

public interface AnalisisRepository extends JpaRepository<AnalisisEntidad, Long> {

	List<AnalisisEntidad> findByCodigoParcelaIn(List<Long> codigos);
	
	List<AnalisisEntidad> findByCodigoParcela(Long codigo);

	@Query(value = "SELECT A.* " + 
			"	FROM LUGAR L, PARCELA P , ANALISIS A" + 
			"	WHERE P.PAR_CODIGO_LUGAR = L.LUG_CODIGO " + 
			"	AND A.ANA_COD_PARCELA = P.PAR_CODIGO " + 
			"	AND L.LUG_CODIGO_USUARIO = ?1 " + 
			"	ORDER BY A.ANA_FECHA_ANALISIS DESC",
			nativeQuery = true)
	List<AnalisisEntidad> findAllByCodigoUsuario(Long codigoUSuario);
}
