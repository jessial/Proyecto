package servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import controladores.ControladorDatos;
import dominio.Requerimiento;

@RestController
@RequestMapping("/servicio_requerimiento")
public class ServicioRequerimiento {
	
	@Autowired
	ControladorDatos controladorDatos;
	
	@GetMapping("/consultaTodos")
	public ResponseEntity<Object> consultar() {
		return new ResponseEntity<>(controladorDatos.consultarRequermientos(), HttpStatus.CREATED);	}
	
	@PostMapping("/guardado")
	public ResponseEntity<Object> grabar(@RequestBody Requerimiento requerimiento) {
		controladorDatos.guardarRequermiento(requerimiento);
		return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
		
	}
	
}
