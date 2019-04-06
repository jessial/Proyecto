package servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import controladores.ControladorDatosParcela;

@RestController
@RequestMapping("/servicio_parcela")
public class ServicioParcela {

	@Autowired
	ControladorDatosParcela controladorDatosParcela;

	@GetMapping("/consultaTodos")
	public ResponseEntity<Object> consultarParcelas() {
		return new ResponseEntity<>(controladorDatosParcela.consultarParcela(), HttpStatus.CREATED);
	}

}
