package servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import controladores.ControladorDatos;
import dominio.Usuario;

@RestController
@RequestMapping("/servicio_usuario")
public class ServicioUsuario {
	
	@Autowired
	ControladorDatos controladorDatos;
	
	@PostMapping("/guardado")
	public ResponseEntity<Object> grabar(@RequestBody Usuario usuario) {
		controladorDatos.guardarUsuarioNuevo(usuario);
		return new ResponseEntity<>(null, HttpStatus.CREATED);

	}

}
