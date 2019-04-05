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

import controladores.ControladorDatosTipoCultivo;
import dominio.TipoCultivo;

@RestController
@RequestMapping("/servicio_tipo_cultivo")
public class ServicioCultivo {

	@Autowired
	ControladorDatosTipoCultivo controladorDatosTipoCultivo;

	@GetMapping("/consultaTodos")
	@ResponseBody
	public ResponseEntity<Object> consultar() {
		return new ResponseEntity<>(controladorDatosTipoCultivo.consultarCultivo(), HttpStatus.CREATED);
	}

	@PostMapping("/guardado")
	@ResponseBody
	public ResponseEntity<Object> grabar(@RequestBody TipoCultivo cultivoSembrado) {
		return this.actualizar(cultivoSembrado);
	}

	@PutMapping("/actualizaRegistro")
	@ResponseBody
	public ResponseEntity<Object> actualizar(@RequestBody TipoCultivo cultivoSembrado) {
		controladorDatosTipoCultivo.guardarTipoCultivo(cultivoSembrado);
		return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("borrarTipoCultivo/{id}")
	@ResponseBody
	public ResponseEntity<Object> eliminar(@PathVariable(value = "id") Long codigoCultivoSembrado) {
		controladorDatosTipoCultivo.eliminarTipoCultivo(codigoCultivoSembrado);
		return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
	}
}
