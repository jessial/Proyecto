package persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import persistencia.entidad.ElementosEntidad;

public interface ElementosRepository extends JpaRepository<ElementosEntidad, Long> {

	ElementosEntidad findByCodigoElemento(Long codigoElemento);

}
