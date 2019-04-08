package controladores;

import java.util.List;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.Lugar;
import dominio.Parcela;
import dto.DTOResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ControladorDatosApp {

	@Autowired
	private ControladorDeDatosRecomendacion controladorDatosRecomendacion;

	@Autowired
	private ControladorDatosRol controladorDatosRol;

	@Autowired
	private ControladorDatosAnalisis controladorDatosAnalisis;

	@Autowired
	private ControladorDatosTipoCultivo controladorDatosTipoCultivo;

	@Autowired
	private ControladorDatosLugar controladorDatosLugar;

	@Autowired
	private ControladorDatosUsuario controladorDatosUsuario;

	@Autowired
	private ControladorDatosParcela controladorDatosParcela;

	/*public DtoResponse consultarDatosPorCedula(Long cedula) {
		DtoResponse respuesta = new DtoResponse();
		respuesta.setUsuario(controladorDatosUsuario.consultarPorCedula(cedula));
		if (null == respuesta.getUsuario().getCedula()) {
			respuesta.setRoles(controladorDatosRol.consultarRoles());
			respuesta.setCultivos(controladorDatosTipoCultivo.consultarCultivo());
		} else {
			respuesta.setRolUsuario(controladorDatosRol.consultarRolPorCodigo(respuesta.getUsuario().getCodigoRol()));
			ImmutablePair<List<Lugar>, List<Long>> pairLugares = controladorDatosLugar
					.consultarLugaresPorUsuario(cedula);
			respuesta.setLugares(pairLugares.getKey());
			ImmutablePair<List<Parcela>, List<Long>> pairParcelas = controladorDatosParcela
					.consultarParcelasPorLugares(pairLugares.getValue());
			respuesta.setParcelas(pairParcelas.getKey());
			respuesta.setAnalisis(controladorDatosAnalisis.consultarAnalisisPorParcela(pairParcelas.getValue()));
			respuesta.setRecomendaciones(
					controladorDatosRecomendacion.consultarRecomendacionesPorParcela(pairParcelas.getValue()));

		}
		return respuesta;
	}
*/
}
