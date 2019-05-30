package servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import controladores.ControladorDatosUsuario;
import dominio.Usuario;
import excepciones.ExcepcionUsuarioDuplicado;

@RestController
@RequestMapping("/servicio_usuario")
public class ServicioUsuario {

	@Autowired
	ControladorDatosUsuario controladorDatosUsuario;

	@PostMapping("/guardadoUsuario")
	public ResponseEntity<Object> grabarUsuarioDesdeApp(@RequestBody Usuario usuario) throws ExcepcionUsuarioDuplicado {
		controladorDatosUsuario.guardarUsuarioNuevo(usuario);
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}

}
