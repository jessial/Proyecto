package servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import controladores.ControladorDatos;
import dominio.TipoCultivo;

@RestController
@RequestMapping("/servicio_tipo_cultivo")
@CrossOrigin(origins = "http://localhost:4200")
public class ServicioCultivo {
	
		@Autowired
		ControladorDatos controladorDatos;
		
		@GetMapping("/consultaTodos")
		@ResponseBody
		public ResponseEntity<Object> consultar() {
			return new ResponseEntity<>(controladorDatos.consultarCultivo(), HttpStatus.CREATED);
		}
		
		@PostMapping("/guardado")
		@ResponseBody
		public ResponseEntity<Object> grabar(@RequestBody TipoCultivo cultivoSembrado) {
			return this.actualizar(cultivoSembrado);
		}
		
		@PutMapping("/actualizaRegistro")
		@ResponseBody
		public ResponseEntity<Object> actualizar(@RequestBody TipoCultivo cultivoSembrado) {
			controladorDatos.guardarTipoCultivo(cultivoSembrado);
			return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
		}
}
