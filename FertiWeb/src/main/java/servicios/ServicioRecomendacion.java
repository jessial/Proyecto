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

import controladores.ControladorDatosRecomendacion;
import dto.FuenteParaRecomendacion;

@RestController
@RequestMapping("/servicio_recomendacion")
public class ServicioRecomendacion {

	@Autowired
	ControladorDatosRecomendacion controladorDatosRecomendacion;

	@GetMapping("/consultaPorAnalisis/{codigoAnalisis}")
	public ResponseEntity<Object> consultarPorAnalisis(@PathVariable Long codigoAnalisis) {
	return new ResponseEntity<>(controladorDatosRecomendacion.consultarPorAnalisis(codigoAnalisis),
	HttpStatus.CREATED);
	}
	
	@PostMapping("/generarRecomendacion")
	public ResponseEntity<Object> consultarPorAnalisis(@RequestBody FuenteParaRecomendacion fuentes) {
		return new ResponseEntity<>(controladorDatosRecomendacion.calcularRecomendacion(fuentes),
				HttpStatus.CREATED);
	}

}
