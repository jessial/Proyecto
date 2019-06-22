package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dominio.Requerimiento;
import dto.DTORequerimiento;
import persistencia.entidad.RequerimientoEntidad;
import persistencia.repositorio.RequerimientoRepository;

public class ControladorDatosRequerimiento extends ControladorDatos {

	
	@Autowired
	private DozerBeanMapper mapperDozer;
	
	@Autowired
	private RequerimientoRepository requerimientoRepository;

	@Autowired
	private ControladorDatosUnidad controladorDatosUnidad;

	@Autowired
	private ControladorDatosTipoCultivo controladorDatosTipoCultivo;

	@Autowired
	private ControladorDatosElemento controladorDatosElemento;

	public List<DTORequerimiento> consultarRequerimientos() {
		 List<Requerimiento> requerimientosModelo = mapearListaADominio(requerimientoRepository.findAll());
		 return construirListaDTO(requerimientosModelo);
	}
	
	public List<DTORequerimiento> consultarRequerimientoPorTipoCultivo(Long codigoTipoCultivo) {
		List<Requerimiento> requerimientosModelo = mapearListaADominio(requerimientoRepository.findByCodigoTipoCultivo(codigoTipoCultivo));
		return construirListaDTO(requerimientosModelo);
	}
	
	private List<Requerimiento> mapearListaADominio(List<RequerimientoEntidad> requerimientoEntidadList) {
		return requerimientoEntidadList.stream().map(a -> mapearADominio(a))
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	private List<DTORequerimiento> construirListaDTO(List<Requerimiento> listRequerimiento) {
		List<DTORequerimiento> listDTORequerimiento = new ArrayList<>();
		for (Requerimiento requerimiento : listRequerimiento) {
			listDTORequerimiento.add(construirDTO(requerimiento));
		}
		return listDTORequerimiento;
	}

	@Override
	protected DTORequerimiento construirDTO(Object object) {
		Requerimiento requerimiento = (Requerimiento) object;
		DTORequerimiento dtoRequerimiento = new DTORequerimiento();
		dtoRequerimiento.setCantidad(requerimiento.getCantidad());
		dtoRequerimiento.setCodigoRequerimiento(requerimiento.getCodigoRequerimiento());
		dtoRequerimiento.setElemento(controladorDatosElemento.consultarElementosXId(requerimiento.getReqCodigoElemento()));
		dtoRequerimiento.setEstado(requerimiento.isEstado());
		dtoRequerimiento.setTipoCultivo(controladorDatosTipoCultivo.consultarTipoCultivoXId(requerimiento.getCodigoTipoCultivo()));
		dtoRequerimiento.setUnidad(controladorDatosUnidad.consultarUnidadXId(requerimiento.getUniCodigo()));
		return dtoRequerimiento;
	}
	
	@Override
	public Requerimiento construirDominio(Object object) {
		DTORequerimiento dtoRequerimiento = (DTORequerimiento) object ;
		Requerimiento requerimiento = new Requerimiento();
		requerimiento.setCantidad(dtoRequerimiento.getCantidad());
		requerimiento.setCodigoRequerimiento(dtoRequerimiento.getCodigoRequerimiento());
		requerimiento.setReqCodigoElemento(dtoRequerimiento.getElemento().getCodigoElemento());
		requerimiento.setEstado(dtoRequerimiento.isEstado());
		requerimiento.setCodigoTipoCultivo(dtoRequerimiento.getTipoCultivo().getCodigoTipoCultivo());
		requerimiento.setUniCodigo(dtoRequerimiento.getUnidad().getCodigoUnidad());
		return requerimiento;
	}

	@Override
	protected Requerimiento mapearADominio(Object object) {
		RequerimientoEntidad requerimientoEntidad = (RequerimientoEntidad) object;
		return mapperDozer.map(requerimientoEntidad, Requerimiento.class);
	}

	@Override
	protected RequerimientoEntidad mapearAEntidad(Object object) {
		Requerimiento requerimiento = (Requerimiento) object;
		return mapperDozer.map(requerimiento, RequerimientoEntidad.class);
	}

	@Transactional
	@Override
	public void guardar(Object object) {
		Requerimiento requerimiento = (Requerimiento) object;
		requerimientoRepository.save(mapearAEntidad(requerimiento));
	}
	
	@Transactional
	public void eliminarRequerimiento(Long codigoRequerimiento) {
		requerimientoRepository.deleteById(codigoRequerimiento);
	}
}
