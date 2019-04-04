package controladores;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.TipoCultivo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import persistencia.entidad.TipoCultivoEntidad;
import persistencia.repositorio.TipoCultivoRepository;

@AllArgsConstructor
@NoArgsConstructor
public class ControladorDatosTipoCultivo {

	@Autowired
	private DozerBeanMapper mapperDozer;
	@Autowired
	private TipoCultivoRepository tipoCultivoRepository;

	public List<TipoCultivo> consultarCultivo() {
		List<TipoCultivo> tiposCultivo = new ArrayList<>();
		List<TipoCultivoEntidad> tiposCultivoEntidad = tipoCultivoRepository.findAll();
		mapperDozer.map(tiposCultivoEntidad, tiposCultivo);
		return tiposCultivo;
	}

	public void guardarTipoCultivo(TipoCultivo tipoCultivo) {
		TipoCultivoEntidad tipoCultivoEntidad = new TipoCultivoEntidad();
		mapperDozer.map(tipoCultivo, tipoCultivoEntidad);
		tipoCultivoRepository.save(tipoCultivoEntidad);
	}

	public void eliminarTipoCultivo(long codigoCultivoSembrado) {
		tipoCultivoRepository.deleteById(codigoCultivoSembrado);
	}
}
