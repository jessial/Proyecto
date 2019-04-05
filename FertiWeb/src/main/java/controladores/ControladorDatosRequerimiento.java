package controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dominio.Elemento;
import dominio.Requerimiento;
import dominio.TipoCultivo;
import dominio.Unidad;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import persistencia.entidad.ElementosEntidad;
import persistencia.entidad.RequerimientoEntidad;
import persistencia.entidad.TipoCultivoEntidad;
import persistencia.entidad.UnidadEntidad;
import persistencia.repositorio.RequerimientoRepository;

@AllArgsConstructor
@NoArgsConstructor
public class ControladorDatosRequerimiento {

	@Autowired
	private RequerimientoRepository requerimientoRepository;

	@Autowired
	private ControladorDatosUnidad controladorDatosUnidad;

	@Autowired
	private ControladorDatosTipoCultivo controladorDatosTipoCultivo;

	@Autowired
	private ControladorDatosElemento controladorDatosElemento;

	public List<Requerimiento> consultarRequerimientos() {
		List<Requerimiento> requerimientosModelo = new ArrayList<>();
		List<RequerimientoEntidad> requerimientosEntidad = requerimientoRepository.findAll();
		requerimientosEntidad.forEach(requerimiento -> {

			TipoCultivoEntidad tipoCultivoEntidad = controladorDatosTipoCultivo
					.consultarTipoCultivoPorId(requerimiento.getCodigoTipoCultivo());

			ElementosEntidad elementosEntidad = controladorDatosElemento
					.consultarElementosPorId(requerimiento.getReqCodigoElemento());

			UnidadEntidad unidadEntidad = controladorDatosUnidad.consultarUnidadPorId(requerimiento.getUniCodigo());

			requerimientosModelo.add(
					convertirRequerimientoAModelo(requerimiento, tipoCultivoEntidad, elementosEntidad, unidadEntidad));
		});
		return requerimientosModelo;
	}

	public void guardarRequermiento(Requerimiento requerimiento) {
		requerimientoRepository.save(convertirRequerimientoAEntidad(requerimiento));
	}

	public void eliminarRequerimiento(Long codigoRequerimiento) {
		requerimientoRepository.deleteById(codigoRequerimiento);

	}

	private Requerimiento convertirRequerimientoAModelo(RequerimientoEntidad requerimientoEntidad,
			TipoCultivoEntidad tipoCultivoEntidad, ElementosEntidad elementoEntidad, UnidadEntidad unidadEntidad) {

		TipoCultivo tipoCultivoDominio = new TipoCultivo(tipoCultivoEntidad.getCodigoTipoCultivo(),
				tipoCultivoEntidad.getNombre(), tipoCultivoEntidad.getVariedad(), tipoCultivoEntidad.isEstado());

		Elemento elementosDominio = new Elemento(elementoEntidad.getCodigoElemento(), elementoEntidad.getElemento());

		Unidad unidadDominio = new Unidad(unidadEntidad.getCodigoUnidad(), unidadEntidad.getNombreUnidad());

		return new Requerimiento(requerimientoEntidad.getCodigoRequerimiento(), tipoCultivoDominio, elementosDominio,
				requerimientoEntidad.isEstado(), requerimientoEntidad.getCantidad(), unidadDominio);
	}

	private RequerimientoEntidad convertirRequerimientoAEntidad(Requerimiento requerimiento) {
		return new RequerimientoEntidad(requerimiento.getCodigoRequerimiento(),
				requerimiento.getTipoCultivo().getCodigoTipoCultivo(), requerimiento.getElemento().getCodigoElemento(),
				requerimiento.isEstado(), requerimiento.getCantidad(), requerimiento.getUnidad().getCodigoUnidad());
	}

}
