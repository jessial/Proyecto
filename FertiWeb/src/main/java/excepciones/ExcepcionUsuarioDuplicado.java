package excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ExcepcionUsuarioDuplicado extends Exception {

	private static final long serialVersionUID = 1L;

	public ExcepcionUsuarioDuplicado(String mensaje) {
		super(mensaje);
	}

}
