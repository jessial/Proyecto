package servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import controladores.ControladorDatos;
import dominio.TipoCultivo;
import persistencia.entidad.TipoCultivoEntidad;

@RestController
@RequestMapping("/servicio_tipo_cultivo")
public class ServicioTipoCultivo {
	
		@Autowired
		ControladorDatos controladorDatos;
		
		@CrossOrigin(origins = "http://localhost:4200")
		@GetMapping("/consultaTodos")
		@ResponseBody
		public ResponseEntity<List<TipoCultivoEntidad>> consultar() {
			//return controladorDatos.consultarTiposCultivo();
			return new ResponseEntity<>(controladorDatos.consultarTiposCultivo(), HttpStatus.CREATED);
		}
		
		@PostMapping("/guardado")
		public ResponseEntity<Object> grabar(@RequestBody TipoCultivo tipoCultivo) {
			controladorDatos.guardarTipoCultivo(tipoCultivo);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
}
