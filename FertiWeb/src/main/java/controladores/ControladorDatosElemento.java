package controladores;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.Elemento;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import persistencia.repositorio.ElementosRepository;

@AllArgsConstructor
@NoArgsConstructor
public class ControladorDatosElemento {

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private ElementosRepository elementoRepository;

	public List<Elemento> consultarElementosParaApp() {
		List<Elemento> elementos = new ArrayList<>();
		mapperDozer.map(elementoRepository.findAll(), elementos);
		return elementos;
	}

}
