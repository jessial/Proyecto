package servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import controladores.ControladorDatos;
import dominio.Analisis;

@RestController
@RequestMapping("/servicio_analisis")
public class ControladorAnalisis {
	
	@Autowired
	ControladorDatos controladorDatos;
	
	@PostMapping("/guardado")
	public ResponseEntity<Object> grabar(@RequestBody Analisis analisisSuelo) {
		controladorDatos.guardarAnalisis(analisisSuelo);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
}
