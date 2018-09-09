package controladores;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import dto.DtoResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ControladorDatosApp {

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private ControladorDatos controladorDatos;

	public DtoResponse consultarDatosPorCedula(Long cedula) {
		DtoResponse respuesta = new DtoResponse();
		respuesta.setUsuario(controladorDatos.consultarPorCedula(cedula));
		if (null == respuesta.getUsuario()) {
			respuesta.setRoles(controladorDatos.consultarRoles());
			respuesta.setCultivos(controladorDatos.consultarCultivo());
		} else {
			respuesta.setRolUsuario(controladorDatos.consultarRolPorCodigo(respuesta.getUsuario().getCodigoRol()));
			respuesta.setLugares(controladorDatos.consultarLugaresPorUsuario(cedula));
			respuesta.setParcelas(controladorDatos.consultarParcelasPorLugares(respuesta.getLugares()));
			respuesta.setAnalisis(controladorDatos.consultarAnalisisPorParcela(respuesta.getParcelas()));
		}
		return respuesta;
	}
}
