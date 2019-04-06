package persistencia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import persistencia.entidad.ParcelaEntidad;

public interface ParcelaRepository extends JpaRepository<ParcelaEntidad, Long> {

	List<ParcelaEntidad> findByCodigoParcelaIn(List<Long> codigos);

	List<ParcelaEntidad> findByCodigoLugar(Long codigoLugar);

	ParcelaEntidad findByCodigoParcela(Long codigoParcela);

}
