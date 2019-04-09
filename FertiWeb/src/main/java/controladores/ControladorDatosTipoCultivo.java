package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dominio.TipoCultivo;
import persistencia.entidad.TipoCultivoEntidad;
import persistencia.repositorio.TipoCultivoRepository;

public class ControladorDatosTipoCultivo extends ControladorDatos {

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private TipoCultivoRepository tipoCultivoRepository;


	public List<TipoCultivo> consultarCultivo() {
		return mapearListaADominio(tipoCultivoRepository.findAll());
	}

	public List<TipoCultivo> consultarCultivoParaApp() {
		boolean estado = true;
		return mapearListaADominio(tipoCultivoRepository.findByEstado(estado));
	}

	public TipoCultivo consultarTipoCultivoXId(Long codigoCultivoSembrado) {
		return mapearADominio(tipoCultivoRepository.findByCodigoTipoCultivo(codigoCultivoSembrado));
	}
	
	private List<TipoCultivo> mapearListaADominio(List<TipoCultivoEntidad> tipoCultivoEntidadList) {
		return tipoCultivoEntidadList.stream().map(a -> mapearADominio(a))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	protected Object construirDTO(Object object) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	protected Object construirDominio(Object object) {
		throw new UnsupportedOperationException();
	}

	@Override
	protected TipoCultivo mapearADominio(Object object) {
		TipoCultivoEntidad tipoCultivoEntidad = (TipoCultivoEntidad) object;
		return mapperDozer.map(tipoCultivoEntidad, TipoCultivo.class);
	}

	@Override
	protected TipoCultivoEntidad mapearAEntidad(Object object) {
		TipoCultivo tipoCultivo = (TipoCultivo) object;
		return mapperDozer.map(tipoCultivo, TipoCultivoEntidad.class);
	}

	@Transactional
	@Override
	public void guardar(Object object) {
		TipoCultivo tipoCultivo = (TipoCultivo) object;
		tipoCultivoRepository.save(mapearAEntidad(tipoCultivo));
	}
	
	@Transactional
	public void eliminarTipoCultivo(long codigoCultivoSembrado) {
		tipoCultivoRepository.deleteById(codigoCultivoSembrado);
	}
}
