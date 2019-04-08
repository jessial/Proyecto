package controladores;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.Elemento;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import persistencia.entidad.ElementosEntidad;
import persistencia.repositorio.ElementosRepository;

@AllArgsConstructor
@NoArgsConstructor
public class ControladorDatosElemento {

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private ElementosRepository elementoRepository;

	public List<Elemento> consultarElementos() {
		List<Elemento> elementos = new ArrayList<>();
		mapperDozer.map(elementoRepository.findAll(), elementos);
		return elementos;
	}

	public ElementosEntidad consultarElementosPorId(Long id) {
		ElementosEntidad elementosEntidad = new ElementosEntidad();
		mapperDozer.map(elementoRepository.findByCodigoElemento(id), elementosEntidad);
		return elementosEntidad;
	}

}
