package controladores;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dominio.Fuente;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import persistencia.entidad.FuenteEntidad;
import persistencia.repositorio.FuenteRepository;

@AllArgsConstructor
@NoArgsConstructor
public class ControladorDatosFuente {

	@Autowired
	private DozerBeanMapper mapperDozer;
	@Autowired
	private FuenteRepository fuenteRepository;

	public List<Fuente> consultarFuente() {
		return fuenteRepository.getTodos();
	}

	public void guardarFuente(Fuente fuente) {
		FuenteEntidad fuenteEntidad = new FuenteEntidad();
		mapperDozer.map(fuente, fuenteEntidad);
		fuenteRepository.save(fuenteEntidad);
	}

	public void eliminarFuente(long codigoFuente) {
		fuenteRepository.deleteById(codigoFuente);
	}

}
