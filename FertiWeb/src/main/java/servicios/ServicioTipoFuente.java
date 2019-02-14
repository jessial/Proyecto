package servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import controladores.ControladorDatos;
import dominio.TipoFuente;

@RestController
@RequestMapping("/servicio_tipoFuente")
public class ServicioTipoFuente {

	@Autowired
	ControladorDatos controladorDatos;

	@GetMapping("/consultaTodos")
	public ResponseEntity<Object> consultar() {
		return new ResponseEntity<>(controladorDatos.consultarTipoFuente(), HttpStatus.CREATED);
	}

	@PutMapping("/guardado")
	public ResponseEntity<Object> grabar(@RequestBody TipoFuente tipoFuente) {
		controladorDatos.guardarTipoFuente(tipoFuente);
		return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("borrarTipoFuente/{id}")
	@ResponseBody
	public ResponseEntity<Object> eliminar(@PathVariable(value = "id") Long codigo) {
		controladorDatos.eliminarTipoFuente(codigo);
		return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
	}

	@GetMapping("/consultaUnidad")
	public ResponseEntity<Object> consultarUnidad() {
		return new ResponseEntity<>(controladorDatos.consultarUnidad(), HttpStatus.CREATED);
	}

}
