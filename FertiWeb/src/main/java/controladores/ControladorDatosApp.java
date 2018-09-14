package controladores;

import java.util.List;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.Lugar;
import dominio.Parcela;
import dto.DtoResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ControladorDatosApp {

	@Autowired
	private ControladorDatos controladorDatos;

	public DtoResponse consultarDatosPorCedula(Long cedula) {
		DtoResponse respuesta = new DtoResponse();
		respuesta.setUsuario(controladorDatos.consultarPorCedula(cedula));
		if (null == respuesta.getUsuario().getCedula()) {
			respuesta.setRoles(controladorDatos.consultarRoles());
			respuesta.setCultivos(controladorDatos.consultarCultivo());
		} else {
			respuesta.setRolUsuario(controladorDatos.consultarRolPorCodigo(respuesta.getUsuario().getCodigoRol()));
			ImmutablePair<List<Lugar>, List<Long>> pairLugares = controladorDatos.consultarLugaresPorUsuario(cedula);
			respuesta.setLugares(pairLugares.getKey());
			ImmutablePair<List<Parcela>, List<Long>> pairParcelas = controladorDatos.consultarParcelasPorLugares(pairLugares.getValue());
			respuesta.setParcelas(pairParcelas.getKey());
			respuesta.setAnalisis(controladorDatos.consultarAnalisisPorParcela(pairParcelas.getValue()));
			respuesta.setRecomendaciones(controladorDatos.consultarRecomendacionesPorParcela(pairParcelas.getValue()));

		}
		return respuesta;
	}
}
