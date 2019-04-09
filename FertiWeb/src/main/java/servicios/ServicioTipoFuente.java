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

import controladores.ControladorDatosTipoFuente;
import controladores.ControladorDatosUnidad;
import dominio.TipoFuente;
import dto.DTOTipoFuente;

@RestController
@RequestMapping("/servicio_tipoFuente")
public class ServicioTipoFuente {

	@Autowired
	ControladorDatosTipoFuente controladorDatosTipoFuente;
	@Autowired
	ControladorDatosUnidad controladorDatosUnidad;

	@GetMapping("/consultaTodos")
	public ResponseEntity<Object> consultar() {
		return new ResponseEntity<>(controladorDatosTipoFuente.consultarTipoFuentes(), HttpStatus.CREATED);
	}

	@PutMapping("/guardado")
	public ResponseEntity<Object> grabar(@RequestBody DTOTipoFuente dtoTipoFuente) {
		TipoFuente tipoFuente = controladorDatosTipoFuente.construirDominio(dtoTipoFuente);
		controladorDatosTipoFuente.guardar(tipoFuente);
		return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("borrarTipoFuente/{id}")
	@ResponseBody
	public ResponseEntity<Object> eliminar(@PathVariable(value = "id") Long codigo) {
		controladorDatosTipoFuente.eliminarTipoFuente(codigo);
		return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
	}

	@GetMapping("/consultaUnidad")
	public ResponseEntity<Object> consultarUnidad() {
		return new ResponseEntity<>(controladorDatosUnidad.consultarUnidad(), HttpStatus.CREATED);
	}

}
