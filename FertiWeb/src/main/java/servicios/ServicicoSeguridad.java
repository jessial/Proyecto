package servicios;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServicicoSeguridad {

	/*@RequestMapping("/login")
	public boolean login(@RequestBody Usuario usuario) {
		return usuario.getCedula().equals("user") && usuario.getPassword().equals("password");
	}

	@RequestMapping("/user")
	public Principal user(HttpServletRequest request) {
		String authToken = request.getHeader("Authorization").substring("Basic".length()).trim();
		return () -> new String(Base64.getDecoder().decode(authToken)).split(":")[0];
	}*/
}
