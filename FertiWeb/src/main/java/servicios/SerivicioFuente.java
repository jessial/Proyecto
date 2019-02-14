package servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import controladores.ControladorDatos;
import dominio.Fuente;

@RestController
@RequestMapping("/servicio_fuente")
public class SerivicioFuente {

	@Autowired
	ControladorDatos controladorDatos;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/consultaTodos")
	@ResponseBody
	public ResponseEntity<Object> consultar() {
		return new ResponseEntity<>(controladorDatos.consultarFuente(), HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/guardado")
	@ResponseBody
	public ResponseEntity<Object> grabar(@RequestBody Fuente fuente) {
		return this.actualizar(fuente);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/actualizaRegistro")
	@ResponseBody
	public ResponseEntity<Object> actualizar(@RequestBody Fuente fuente) {
		controladorDatos.guardarFuente(fuente);
		;
		return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("borrarFuente/{id}")
	@ResponseBody
	public ResponseEntity<Object> eliminar(@PathVariable(value = "id") Long codigoFuente) {
		controladorDatos.eliminarFuente(codigoFuente);
		return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
	}

}