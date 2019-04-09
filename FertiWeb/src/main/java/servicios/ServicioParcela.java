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

import controladores.ControladorDatosParcela;
import dominio.Parcela;

@RestController
@RequestMapping("/servicio_parcela")
public class ServicioParcela {

	@Autowired
	ControladorDatosParcela controladorDatosParcela;

	@GetMapping("/consultaTodos")
	public ResponseEntity<Object> consultarParcelas() {
		return new ResponseEntity<>(controladorDatosParcela.consultarParcela(), HttpStatus.CREATED);
	}

	@PostMapping("/guardado")
	@ResponseBody
	public ResponseEntity<Object> grabarParcelDesdeApp(@RequestBody Parcela parcela) {
		return this.actualizar(parcela);
	}

	@PutMapping("/actualizaRegistro")
	@ResponseBody
	public ResponseEntity<Object> actualizar(@RequestBody Parcela parcela) {
		controladorDatosParcela.guardarParcela(parcela);
		return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("borrarParcela/{codigo}")
	@ResponseBody
	public ResponseEntity<Object> eliminar(@PathVariable(value = "codigo") Long codigoParcela) {
		controladorDatosParcela.eliminarParcela(codigoParcela);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
