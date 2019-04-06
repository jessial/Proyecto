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

import controladores.ControladorDatosLugar;
import dominio.Lugar;

@RestController
@RequestMapping("/servicio_lugar")
public class ServicioLugar {

	@Autowired
	ControladorDatosLugar controladorDatosLugar;

	@GetMapping("/consultaTodos")
	@ResponseBody
	public ResponseEntity<Object> consultar() {
		return new ResponseEntity<>(controladorDatosLugar.consultarFincas(), HttpStatus.CREATED);
	}

	@PostMapping("/guardado")
	@ResponseBody
	public ResponseEntity<Object> grabarFincaDesdeApp(@RequestBody Lugar lugar) {
		return this.actualizar(lugar);
	}

	@PutMapping("/actualizaRegistro")
	@ResponseBody
	public ResponseEntity<Object> actualizar(@RequestBody Lugar lugar) {
		controladorDatosLugar.guardarLugar(lugar);
		return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("borrarLugar/{codigo}")
	@ResponseBody
	public ResponseEntity<Object> eliminar(@PathVariable(value = "codigo") Long codigoLugar) {
		controladorDatosLugar.eliminarLugar(codigoLugar);
		return new ResponseEntity<>("No se puede borrar", HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/consultaLugar/{cedula}")
	public ResponseEntity<Object> consultarLugarPorUsuarioParaApp(@PathVariable("cedula") Long cedula) {
		return new ResponseEntity<>(controladorDatosLugar.consultarLugaresPorUsuario(cedula), HttpStatus.CREATED);
	}

}
