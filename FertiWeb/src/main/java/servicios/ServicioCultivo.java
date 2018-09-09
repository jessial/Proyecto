package servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import controladores.ControladorDatos;
import dominio.CultivoSembrado;
import persistencia.entidad.CultivoSembradoEntidad;

@RestController
@RequestMapping("/servicio_tipo_cultivo")
public class ServicioCultivo {
	
		@Autowired
		ControladorDatos controladorDatos;
		
		@CrossOrigin(origins = "http://localhost:4200")
		@GetMapping("/consultaTodos")
		@ResponseBody
		public ResponseEntity<List<CultivoSembrado>> consultar() {
			return new ResponseEntity<>(controladorDatos.consultarCultivo(), HttpStatus.CREATED);
		}
		
		@PostMapping("/guardado")
		public ResponseEntity<Object> grabar(@RequestBody CultivoSembrado cultivoSembrado) {
			controladorDatos.guardarTipoCultivo(cultivoSembrado);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
}
