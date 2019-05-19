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

import controladores.ControladorDatosFuente;
import dominio.Fuente;

@RestController
@RequestMapping("/servicio_fuente")
public class SerivicioFuente {

	@Autowired
	ControladorDatosFuente controladorDatosFuente;

	@GetMapping("/consultaTodos")
	@ResponseBody
	public ResponseEntity<Object> consultar() {
		return new ResponseEntity<>(controladorDatosFuente.consultarFuentes(), HttpStatus.OK);
	}

	@PostMapping("/guardado")
	@ResponseBody
	public ResponseEntity<Object> grabar(@RequestBody Fuente fuente) {
		return this.actualizar(fuente);
	}

	@PutMapping("/actualizaRegistro")
	@ResponseBody
	public ResponseEntity<Object> actualizar(@RequestBody Fuente fuente) {
		controladorDatosFuente.guardar(fuente);
		return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("borrarFuente/{id}")
	@ResponseBody
	public ResponseEntity<Object> eliminar(@PathVariable(value = "id") Long codigoFuente) {
		controladorDatosFuente.eliminarFuente(codigoFuente);
		return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
	}

	@GetMapping("/consultaNitrogeno")
	@ResponseBody
	public ResponseEntity<Object> consultarFuentesParaNitrogeno() {
		return new ResponseEntity<>(controladorDatosFuente.consultarFuentesParaNitrogeno(), HttpStatus.OK);
	}

	@GetMapping("/consultaFosforo")
	@ResponseBody
	public ResponseEntity<Object> consultarFuentesParaFosforo() {
		return new ResponseEntity<>(controladorDatosFuente.consultarFuentesParaFosforo(), HttpStatus.OK);
	}

	@GetMapping("/consultaPotasio")
	@ResponseBody
	public ResponseEntity<Object> consultarFuentesParaPotasio() {
		return new ResponseEntity<>(controladorDatosFuente.consultarFuentesParaPotasio(), HttpStatus.OK);
	}
}
