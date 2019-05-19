package persistencia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import persistencia.entidad.FuenteEntidad;

public interface FuenteRepository extends JpaRepository<FuenteEntidad, Long> {

	@Query(value = "SELECT DISTINCT F.* " + "	FROM FUENTE F, TIPO_FUENTE TF"
			+ "	WHERE F.FUE_CODIGO_TIPO_FUENTE = TF.TF_CODIGO " + "	AND TF.TF_CODIGO_ELEMENTO = 1 ", nativeQuery = true)
	List<FuenteEntidad> findAllByNitrogeno();

	@Query(value = "SELECT DISTINCT F.* " + "	FROM FUENTE F, TIPO_FUENTE TF"
			+ "	WHERE F.FUE_CODIGO_TIPO_FUENTE = TF.TF_CODIGO " + "	AND TF.TF_CODIGO_ELEMENTO = 2 ", nativeQuery = true)

	List<FuenteEntidad> findAllByFosforo();

	@Query(value = "SELECT DISTINCT F.* " + "	FROM FUENTE F, TIPO_FUENTE TF"
			+ "	WHERE F.FUE_CODIGO_TIPO_FUENTE = TF.TF_CODIGO " + "	AND TF.TF_CODIGO_ELEMENTO = 3 ", nativeQuery = true)

	List<FuenteEntidad> findAllByPotasio();

}
