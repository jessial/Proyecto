package servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import controladores.ControladorDatos;
import dominio.Rol;
import dominio.TipoCultivo;
import persistencia.entidad.RolEntidad;

@RestController
@RequestMapping("/servicio_rol")
public class ServicioRol {

	@Autowired
	ControladorDatos controladorDatos;
	
	@GetMapping("/consultaTodos")
	public List<Rol> consultar() {
		return controladorDatos.consultarRoles();
		//return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PostMapping("/guardado")
	public ResponseEntity<Object> grabar(@RequestBody Rol rol) {
		controladorDatos.guardarRol(rol);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
