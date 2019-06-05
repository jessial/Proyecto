package persistencia.repositorio;

import java.util.List;

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
}
