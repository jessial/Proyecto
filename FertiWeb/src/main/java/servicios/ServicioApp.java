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
import controladores.ControladorDatosAnalisis;
import controladores.ControladorDatosApp;
import controladores.ControladorDatosElemento;
import controladores.ControladorDatosLugar;
import controladores.ControladorDatosParcela;
import controladores.ControladorDatosRol;
import controladores.ControladorDatosUsuario;
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

	@Autowired
	ControladorDatosRol controladorDatosRol;

	@Autowired
	ControladorDatosElemento controladorDatosElemento;

	@Autowired
	ControladorDatosAnalisis controladorDatosAnalisis;

	@Autowired
	ControladorDatosLugar controladorDatosLugar;

	@Autowired
	ControladorDatosUsuario controladorDatosUsuario;

	@Autowired
	ControladorDatosParcela controladorDatosParcela;

	// corregir
	@GetMapping("/consulta_datos_bd/{cedula}/{password}")
	public ResponseEntity<DtoResponse> consultar(@PathVariable("cedula") Long cedula,
			@PathVariable("password") Long password) {
		return new ResponseEntity<>(controladorDatosApp.consultarDatosPorCedula(cedula), HttpStatus.CREATED);
	}

	@PostMapping("/guardadoAnalisis")
	public ResponseEntity<Object> grabarAnalisis(@RequestBody Analisis analisisSuelo) {
		controladorDatosAnalisis.guardarAnalisis(analisisSuelo);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PostMapping("/guardadoUsuario")
	public ResponseEntity<Object> grabarUsuario(@RequestBody Usuario usuario) {
		controladorDatosUsuario.guardarUsuarioNuevo(usuario);
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}

	@GetMapping("/consultaRoles")
	public ResponseEntity<Object> consultarRoles() {
		return new ResponseEntity<>(controladorDatosRol.consultarRolesParaApp(), HttpStatus.CREATED);
	}

	@GetMapping("/consultaElementos")
	public ResponseEntity<Object> consultarElementos() {
		return new ResponseEntity<>(controladorDatosElemento.consultarElementosParaApp(), HttpStatus.CREATED);
	}

	@PostMapping("/guardadoLugar")
	public ResponseEntity<Object> grabarLugar(@RequestBody Lugar lugar) {
		controladorDatosLugar.guardarLugar(lugar);
		return new ResponseEntity<>(null, HttpStatus.CREATED);

	}

	@GetMapping("/consultaLugar/{cedula}")
	public ResponseEntity<Object> consultarLugar(@PathVariable("cedula") Long cedula) {
		return new ResponseEntity<>(controladorDatosLugar.consultarLugaresPorUsuario(cedula), HttpStatus.CREATED);
	}

	@DeleteMapping("borrarLugar/{codigo}")
	@ResponseBody
	public ResponseEntity<Object> eliminar(@PathVariable(value = "codigo") Long codigoLugar) {
		controladorDatosLugar.eliminarLugar(codigoLugar);
		return new ResponseEntity<>("No se puede borrar", HttpStatus.ACCEPTED);
	}

	@PostMapping("/guardadoParcela")
	public ResponseEntity<Object> grabarParcela(@RequestBody Parcela parcela) {
		controladorDatosParcela.guardarParcela(parcela);
		return new ResponseEntity<>(null, HttpStatus.CREATED);

	}
}
