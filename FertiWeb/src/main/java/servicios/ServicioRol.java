package servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import controladores.ControladorDatos;
import dominio.Rol;
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
}
