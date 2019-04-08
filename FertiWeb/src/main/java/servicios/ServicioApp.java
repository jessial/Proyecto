package servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import controladores.ControladorDatosAnalisis;
import controladores.ControladorDatosApp;
import controladores.ControladorDatosElemento;
import controladores.ControladorDatosParcela;
import controladores.ControladorDatosRol;
import controladores.ControladorDatosUsuario;
import dominio.ElementoXAnalisis;

@RestController
@RequestMapping("/servicio_app")
public class ServicioApp {

	@Autowired
	ControladorDatosApp controladorDatosApp;

	@Autowired
	ControladorDatosRol controladorDatosRol;

	@Autowired
	ControladorDatosElemento controladorDatosElemento;

	@Autowired
	ControladorDatosAnalisis controladorDatosAnalisis;

	@Autowired
	ControladorDatosUsuario controladorDatosUsuario;

	@Autowired
	ControladorDatosParcela controladorDatosParcela;

	/*
	 * // corregir
	 * 
	 * @GetMapping("/consulta_datos_bd/{cedula}/{password}") public
	 * ResponseEntity<DtoResponse> consultar(@PathVariable("cedula") Long cedula,
	 * 
	 * @PathVariable("password") Long password) { return new
	 * ResponseEntity<>(controladorDatosApp.consultarDatosPorCedula(cedula),
	 * HttpStatus.CREATED); }
	 */

	@PostMapping("/guardadoAnalisis")
	public ResponseEntity<Object> grabarAnalisis(@RequestBody ElementoXAnalisis analisisSuelo) {
		controladorDatosAnalisis.guardarAnalisis(analisisSuelo);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
