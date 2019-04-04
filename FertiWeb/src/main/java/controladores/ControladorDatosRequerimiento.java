package controladores;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.Requerimiento;
import dto.RequerimientoPorCultivo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import persistencia.entidad.RequerimientoEntidad;
import persistencia.repositorio.RequerimientoRepository;

@AllArgsConstructor
@NoArgsConstructor
public class ControladorDatosRequerimiento {
	@Autowired
	private DozerBeanMapper mapperDozer;
	@Autowired
	private RequerimientoRepository requerimientoRepository;

	public List<RequerimientoPorCultivo> consultarRequermientos() {
		return requerimientoRepository.getTodos();
	}

	public void guardarRequermiento(Requerimiento requerimiento) {
		RequerimientoEntidad requerimientoEntidad = new RequerimientoEntidad();
		mapperDozer.map(requerimiento, requerimientoEntidad);
		requerimientoRepository.save(requerimientoEntidad);
	}
}
