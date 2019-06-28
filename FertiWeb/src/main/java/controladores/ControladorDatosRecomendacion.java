package controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import conversores.Conversor;
import dominio.FuenteXRecomendacion;
import dominio.Recomendacion;
import dominio.Unidad;
import dto.DTOAnalisis;
import dto.DTOElementoXAnalisis;
import dto.DTORecomendacion;
import dto.DTORequerimiento;
import dto.FuenteParaRecomendacion;
import persistencia.entidad.RecomendacionEntidad;
import persistencia.repositorio.RecomendacionRepository;

public class ControladorDatosRecomendacion {

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private Conversor conversor;

	@Autowired
	private RecomendacionRepository recomendacionRepository;

	@Autowired
	private ControladorDatosAnalisis controladorDatosAnalisis;

	@Autowired
	private ControladorDatosRequerimiento controladorDatosRequerimiento;

	@Autowired
	private ControladorDatosFuenteXRecomendacion controladorDatosFuenteXRecomendacion;

	public List<DTORecomendacion> consultarPorAnalisis(Long codigoAnalisis) {
		List<Recomendacion> listRecomendacion = mapearListaADominio(
				recomendacionRepository.findBycodigoAnalisis(codigoAnalisis));
		return construirListaDTO(listRecomendacion);
	}

	private List<Recomendacion> mapearListaADominio(List<RecomendacionEntidad> recomendacionEntidadList) {
		return recomendacionEntidadList.stream().map(a -> mapearADominio(a))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	private List<DTORecomendacion> construirListaDTO(List<Recomendacion> listRecomendacion) {
		List<DTORecomendacion> listDtoRecomendacion = new ArrayList<>();
		for (Recomendacion recomendacion : listRecomendacion) {
			listDtoRecomendacion.add(construirDTO(recomendacion));
		}
		return listDtoRecomendacion;
	}

	protected DTORecomendacion construirDTO(Object object) {
		Recomendacion recomendacion = (Recomendacion) object;
		DTORecomendacion dtoRecomendacion = new DTORecomendacion();
		dtoRecomendacion.setCodigoRecomendacion(recomendacion.getCodigoRecomendacion());
		dtoRecomendacion.setAnalisis(controladorDatosAnalisis.consultarAnalisisXId(recomendacion.getCodigoAnalisis()));
		dtoRecomendacion.setFechaRecomendacion(recomendacion.getFechaRecomendacion());
		dtoRecomendacion.setRecomendacionXFuente(controladorDatosFuenteXRecomendacion
				.consultarFuentePorRecomendacion(recomendacion.getCodigoRecomendacion()));
		return dtoRecomendacion;
	}

	protected Recomendacion construirDominio(Object object) {
		DTORecomendacion dtoRecomendacion = (DTORecomendacion) object;
		Recomendacion recomendacion = new Recomendacion();
		recomendacion.setCodigoRecomendacion(dtoRecomendacion.getCodigoRecomendacion());
		recomendacion.setCodigoAnalisis(dtoRecomendacion.getAnalisis().getCodigoAnalisis());
		recomendacion.setFechaRecomendacion(dtoRecomendacion.getFechaRecomendacion());

		return recomendacion;
	}

	protected Recomendacion mapearADominio(Object object) {
		RecomendacionEntidad recomendacionEntidad = (RecomendacionEntidad) object;
		return mapperDozer.map(recomendacionEntidad, Recomendacion.class);
	}

	protected RecomendacionEntidad mapearAEntidad(Object object) {
		Recomendacion recomendacion = (Recomendacion) object;
		return mapperDozer.map(recomendacion, RecomendacionEntidad.class);
	}

	public DTORecomendacion calcularRecomendacion(FuenteParaRecomendacion fuentes) {
		DTOAnalisis analisis = fuentes.getDtoAnalisis();
		Map<Long, DTOElementoXAnalisis> elementos = obtenerElementos(analisis);
		Recomendacion recomendacion = new Recomendacion();
		recomendacion.setCodigoAnalisis(analisis.getCodigoAnalisis());
		recomendacion.setFechaRecomendacion(new Date());
		recomendacion.setCodigoRecomendacion(guardar(recomendacion));
		for (Map.Entry<Long, DTOElementoXAnalisis> pair : elementos.entrySet()) {
			FuenteXRecomendacion fuenteXRecomendacion = new FuenteXRecomendacion();
			double ppmElemento = convertirAPPM(pair.getValue());
			double kgElemento = conversor.convertirPPMAKg(ppmElemento);
			List<DTORequerimiento> dtoRequerimientos = controladorDatosRequerimiento
					.consultarRequerimientoPorTipoCultivo(
							analisis.getParcela().getTipoCultivo().getCodigoTipoCultivo());
			double cantidadRequerida = obtenerCantidadElementoRequerimiento(dtoRequerimientos, pair.getKey())
					- kgElemento;
			if (cantidadRequerida < 0) {
				fuenteXRecomendacion.setCantidad(0.0);
				fuenteXRecomendacion.setCodigoFuente(pair.getKey());
				fuenteXRecomendacion.setCodigoRecomendacion(recomendacion.getCodigoRecomendacion());
				fuenteXRecomendacion.setCodigoUnidad(3L);
			} else {
				fuenteXRecomendacion.setCantidad(cantidadRequerida);
				fuenteXRecomendacion.setCodigoFuente(pair.getKey());
				fuenteXRecomendacion.setCodigoRecomendacion(recomendacion.getCodigoRecomendacion());
				fuenteXRecomendacion.setCodigoUnidad(3L);
			}
			controladorDatosFuenteXRecomendacion.guardar(fuenteXRecomendacion);
		}
		return construirDTO(recomendacion);
	}

	private double obtenerCantidadElementoRequerimiento(List<DTORequerimiento> dtoRequerimientos, Long codigoElemento) {
		Optional<DTORequerimiento> dtoRequerimiento = dtoRequerimientos.stream()
				.filter(r -> r.getElemento().getCodigoElemento() == codigoElemento).findFirst();
		return dtoRequerimiento.isPresent() ? dtoRequerimiento.get().getCantidad() : 0L;
	}

	private Map<Long, DTOElementoXAnalisis> obtenerElementos(DTOAnalisis analisis) {
		Map<Long, DTOElementoXAnalisis> elementos = new HashMap<>();
		for (DTOElementoXAnalisis dtoElemento : analisis.getElementos()) {
			if (dtoElemento.getElemento().getCodigoElemento() == 1) {
				elementos.put(1L, dtoElemento);
			} else if (dtoElemento.getElemento().getCodigoElemento() == 2) {
				elementos.put(2L, dtoElemento);
			} else if (dtoElemento.getElemento().getCodigoElemento() == 3) {
				elementos.put(3L, dtoElemento);
			}
		}
		return elementos;
	}

	private Double convertirAPPM(DTOElementoXAnalisis elemento) {
		Unidad unidad = elemento.getUnidad();
		double ppmElemento = elemento.getCantidad();
		if (unidad.getCodigoUnidad() == 2) {
			ppmElemento = conversor.convertirCmolKgAPPM(elemento.getCantidad(), elemento.getElemento());
		} else if (unidad.getCodigoUnidad() == 4) {
			ppmElemento = conversor.convertirPorcentajeAPPM(elemento.getCantidad());
		}
		return ppmElemento;
	}

	@Transactional
	public Long guardar(Object object) {
		Recomendacion recomendacion = (Recomendacion) object;
		return recomendacionRepository.save(mapearAEntidad(recomendacion)).getCodigoRecomendacion();
	}

}
