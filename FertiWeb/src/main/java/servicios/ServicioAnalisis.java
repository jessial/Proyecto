package servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import controladores.ControladorDatosAnalisis;
import dominio.Analisis;

@RestController
@RequestMapping("/servicio_analisis")
public class ServicioAnalisis {

	@Autowired
	ControladorDatosAnalisis controladorDatosAnalisis;

	@GetMapping("/consultaTodos")
	public ResponseEntity<Object> consultar() {
		return new ResponseEntity<>(controladorDatosAnalisis.consultarTodos(), HttpStatus.CREATED);
	}

	@GetMapping("/consultaPorParcela")
	public ResponseEntity<Object> consultarPorParcela(@PathVariable long codigoParcela) {
		return new ResponseEntity<>(controladorDatosAnalisis.consultarAnalisisPorParcela(codigoParcela),
				HttpStatus.CREATED);
	}
	
	@PostMapping("/guardadoAnalisis")
	public ResponseEntity<Object> grabarAnalisis(@RequestBody Analisis analisis) {
		controladorDatosAnalisis.guardar(analisis);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
