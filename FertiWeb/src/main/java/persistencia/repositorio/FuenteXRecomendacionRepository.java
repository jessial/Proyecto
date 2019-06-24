package persistencia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import persistencia.entidad.FuenteXRecomendacionEntidad;

public interface FuenteXRecomendacionRepository extends JpaRepository<FuenteXRecomendacionEntidad, Long> {

	List<FuenteXRecomendacionEntidad> findByCodigoRecomendacion(Long codigoRecomendacion);

	FuenteXRecomendacionEntidad findFirstByCodigoFuente(Long codigoFuente);

}
