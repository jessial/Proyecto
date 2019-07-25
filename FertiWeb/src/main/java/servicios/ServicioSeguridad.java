package servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import controladores.ControladorSeguridad;

@RestController
@RequestMapping("/servicio_seguridad")
public class ServicioSeguridad {

	@Autowired
	private ControladorSeguridad controladorSeguridad;

	@GetMapping("/recuperar_cuenta/{cedula}")
	public ResponseEntity<Object> recuperarCuenta(@PathVariable long cedula) {
		controladorSeguridad.cambiarClave(cedula);
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}

}
