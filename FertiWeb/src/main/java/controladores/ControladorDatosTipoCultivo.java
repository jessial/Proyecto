package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import constantes.MensajesConstantes;
import dominio.TipoCultivo;
import excepciones.ExcepcionClaveForanea;
import persistencia.entidad.ParcelaEntidad;
import persistencia.entidad.RequerimientoEntidad;
import persistencia.entidad.TipoCultivoEntidad;
import persistencia.repositorio.ParcelaRepository;
import persistencia.repositorio.RequerimientoRepository;
import persistencia.repositorio.TipoCultivoRepository;

public class ControladorDatosTipoCultivo extends ControladorDatos {

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private TipoCultivoRepository tipoCultivoRepository;

	@Autowired
	private RequerimientoRepository requerimientoRepository;

	@Autowired
	private ParcelaRepository parcelaRepository;

	@Cacheable("GlobalCacheConstant.CACHE_CULTIVOS")
	public List<TipoCultivo> consultarCultivo() {
		return mapearListaADominio(tipoCultivoRepository.findAll());
	}

	@Cacheable("GlobalCacheConstant.CACHE_CULTIVOS_APP")
	public List<TipoCultivo> consultarCultivoParaApp() {
		boolean estado = true;
		return mapearListaADominio(tipoCultivoRepository.findByEstado(estado));
	}

	@Cacheable("GlobalCacheConstant.CACHE_CULTIVO")
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
	@CacheEvict(value = { "GlobalCacheConstant.CACHE_CULTIVOS", "GlobalCacheConstant.CACHE_CULTIVOS_APP",
			"GlobalCacheConstant.CACHE_CULTIVO" }, allEntries = true)
	public void guardar(Object object) {
		TipoCultivo tipoCultivo = (TipoCultivo) object;
		tipoCultivoRepository.save(mapearAEntidad(tipoCultivo));
	}

	@Transactional
	@CacheEvict(value = { "GlobalCacheConstant.CACHE_CULTIVOS", "GlobalCacheConstant.CACHE_CULTIVOS_APP",
			"GlobalCacheConstant.CACHE_CULTIVO" }, allEntries = true)
	public void eliminarTipoCultivo(long codigoCultivoSembrado) {
		List<RequerimientoEntidad> requerimientos = requerimientoRepository
				.findByCodigoTipoCultivo(codigoCultivoSembrado);
		if (!requerimientos.isEmpty())
			throw new ExcepcionClaveForanea(MensajesConstantes.ERROR_ASOCIACION_REQUERIMIENTO);

		List<ParcelaEntidad> parcelas = parcelaRepository.findByCodigoCultivoSembrado(codigoCultivoSembrado);
		if (!parcelas.isEmpty())
			throw new ExcepcionClaveForanea(MensajesConstantes.ERROR_ASOCIACION_PARCELA);

		tipoCultivoRepository.deleteById(codigoCultivoSembrado);
	}
}
