package servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import controladores.ControladorDatos;

@RestController
@RequestMapping("/servicio_analisis")
public class ServicioAnalisis {

	@Autowired
	ControladorDatos controladorDatos;

	@GetMapping("/consultaTodos")
	public ResponseEntity<Object> consultar() {
		return new ResponseEntity<>(controladorDatos.consultarAnalisisParaAdministrador(), HttpStatus.CREATED);
	}

}
