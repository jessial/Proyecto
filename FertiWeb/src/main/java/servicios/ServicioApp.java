package servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import controladores.ControladorDatos;
import controladores.ControladorDatosApp;
import dominio.Analisis;
import dominio.Lugar;
import dominio.Parcela;
import dominio.Usuario;
import dto.DtoResponse;

@RestController
@RequestMapping("/servicio_app")
public class ServicioApp {

	@Autowired
	ControladorDatosApp controladorDatosApp;

	@Autowired
	ControladorDatos controladorDatos;

	@GetMapping("/consulta_datos_bd/{cedula}/{password}")
	public ResponseEntity<DtoResponse> consultar(@PathVariable("cedula") Long cedula,
			@PathVariable("password") Long password) {
		return new ResponseEntity<>(controladorDatosApp.consultarDatosPorCedula(cedula), HttpStatus.CREATED);
	}

	@PostMapping("/guardadoAnalisis")
	public ResponseEntity<Object> grabarAnalisis(@RequestBody Analisis analisisSuelo) {
		controladorDatos.guardarAnalisis(analisisSuelo);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PostMapping("/guardadoUsuario")
	public ResponseEntity<Object> grabarUsuario(@RequestBody Usuario usuario) {
		controladorDatos.guardarUsuarioNuevo(usuario);
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}

	@GetMapping("/consultaRoles")
	public ResponseEntity<Object> consultarRoles() {
		return new ResponseEntity<>(controladorDatos.consultarRolesParaApp(), HttpStatus.CREATED);
	}

	@GetMapping("/consultaElementos")
	public ResponseEntity<Object> consultarElementos() {
		return new ResponseEntity<>(controladorDatos.consultarElementosParaApp(), HttpStatus.CREATED);
	}

	@PostMapping("/guardadoLugar")
	public ResponseEntity<Object> grabarLugar(@RequestBody Lugar lugar) {
		controladorDatos.guardarLugar(lugar);
		return new ResponseEntity<>(null, HttpStatus.CREATED);

	}

	@GetMapping("/consultaLugar/{cedula}")
	public ResponseEntity<Object> consultarLugar(@PathVariable("cedula") Long cedula) {
		return new ResponseEntity<>(controladorDatos.consultarLugaresPorUsuario(cedula), HttpStatus.CREATED);
	}

	@DeleteMapping("borrarLugar/{codigo}")
	@ResponseBody
	public ResponseEntity<Object> eliminar(@PathVariable(value = "codigo") Long codigoLugar) {
		controladorDatos.eliminarLugar(codigoLugar);
		return new ResponseEntity<>("No se puede borrar", HttpStatus.ACCEPTED);
	}

	@PostMapping("/guardadoParcela")
	public ResponseEntity<Object> grabarParcela(@RequestBody Parcela parcela) {
		controladorDatos.guardarParcela(parcela);
		return new ResponseEntity<>(null, HttpStatus.CREATED);

	}
}
