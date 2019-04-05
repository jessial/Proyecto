package persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import persistencia.entidad.TipoCultivoEntidad;

public interface TipoCultivoRepository extends JpaRepository<TipoCultivoEntidad, Long> {

	TipoCultivoEntidad findByCodigoTipoCultivo(Long codigoTipoCultivo);

}
