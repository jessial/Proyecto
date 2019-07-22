package servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.exceptions.UnirestException;

import controladores.ControladorDatosUsuario;
import controladores.ControladorSeguridad;
import dominio.Usuario;
import utilidades.ServicioEnvioCorreos;

@RestController
@RequestMapping("/servicio_seguridad")
public class ServicicoSeguridad {

	@Autowired
	private ControladorDatosUsuario controladorDatosUsuario;
	
	@Autowired
	private ControladorSeguridad controladorSeguridad;

	@GetMapping("/recuperar_cuenta/{cedula}")
	public ResponseEntity<Object> consultar(@PathVariable long cedula) {
		try {
			Usuario usuario = controladorDatosUsuario.consultarPorCedula(cedula);
			usuario.setPassword(controladorSeguridad.cambiarClave(usuario.getCedula()));
			controladorDatosUsuario.guardarUsuario(usuario);
			ServicioEnvioCorreos.MGSample.sendSimpleMessage(usuario.getEmail(), usuario.getPassword());
		} catch (UnirestException e) {
			e.getStackTrace();
		}
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}
	
}
