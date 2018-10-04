package servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import controladores.ControladorDatos;
import dominio.Rol;

@RestController
@RequestMapping("/servicio_rol")
public class ServicioRol {

	@Autowired
	ControladorDatos controladorDatos;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/consultaTodos")
	public ResponseEntity<Object> consultar() {
		return new ResponseEntity<>(controladorDatos.consultarRoles(), HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/guardado")
	public ResponseEntity<Object> grabar(@RequestBody Rol rol) {
		controladorDatos.guardarRol(rol);
		return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
	}
}
