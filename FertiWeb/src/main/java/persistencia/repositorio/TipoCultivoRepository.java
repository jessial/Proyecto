package persistencia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import persistencia.entidad.TipoCultivoEntidad;

public interface TipoCultivoRepository extends JpaRepository<TipoCultivoEntidad, Long> {

	TipoCultivoEntidad findByCodigoTipoCultivo(Long codigoTipoCultivo);

	List<TipoCultivoEntidad> findByEstado(boolean estado);

}
