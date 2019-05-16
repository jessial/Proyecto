package servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import controladores.ControladorDatosRol;
import dominio.Rol;

@RestController
@RequestMapping("/servicio_rol")
public class ServicioRol {

	@Autowired
	ControladorDatosRol controladorDatosRol;

	@GetMapping("/consultaTodos")
	public ResponseEntity<Object> consultar() {
		return new ResponseEntity<>(controladorDatosRol.consultarRoles(), HttpStatus.CREATED);
	}

	@PostMapping("/guardado")
	public ResponseEntity<Object> grabar(@RequestBody Rol rol) {
		controladorDatosRol.guardar(rol);
		return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
	}

	@PutMapping("/actualizaRegistro")
	@ResponseBody
	public ResponseEntity<Object> actualizar(@RequestBody Rol rol) {
		return grabar(rol);
	}

	@DeleteMapping("borrarRol/{id}")
	@ResponseBody
	public ResponseEntity<Object> eliminar(@PathVariable(value = "id") Long codigoRol) {
		controladorDatosRol.eliminarRol(codigoRol);
		return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
	}

	@GetMapping("/consultaRoles")
	public ResponseEntity<Object> consultarRolesParaApp() {
		return new ResponseEntity<>(controladorDatosRol.consultarRolesParaApp(), HttpStatus.CREATED);
	}
}
