package persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import persistencia.entidad.CultivoSembradoEntidad;

public interface CultivoSembradoRepository extends JpaRepository<CultivoSembradoEntidad, Long> {

}
