package utilidades;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


public class ServicioEnvioCorreos {
	
	private static final String DOMAIN_NAME = "sandbox8fb7696a9dc145e3a2cf8e0d08048144.mailgun.org";
	private static final String API_KEY = "dd6e29089dc49d0e2538186aa9c536b0-afab6073-817d6eff";
	
	public static class MGSample {

	    public static JsonNode sendSimpleMessage(String correo, String nuevaClave) throws UnirestException {

	        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + DOMAIN_NAME + "/messages")
	            .basicAuth("api", API_KEY)
	            .field("from", "Excited User <USER@YOURDOMAIN.COM>")
	            .field("to", correo)
	            .field("subject", "Cambio de clave FERTIAPP")
	            .field("text", "NUEVA CLAVE: " + nuevaClave)
	            .asJson();

	        return request.getBody();
	    }
	}
}