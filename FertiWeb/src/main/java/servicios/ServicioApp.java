package servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import controladores.ControladorDatosApp;
import dto.DtoResponse;

@RestController
@RequestMapping("/servicio_app")
public class ServicioApp {
	
	@Autowired
	ControladorDatosApp controladorDatosApp;

	@GetMapping("/consulta_datos_bd/{cedula}")
	public ResponseEntity<DtoResponse> consultar(@PathVariable("cedula") Long cedula) {
		return new ResponseEntity<>(controladorDatosApp.consultarDatosPorCedula(cedula), HttpStatus.CREATED);
	}
}
