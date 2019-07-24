package utilidades;

import java.io.IOException;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class ServicioEnvioCorreos {

	private static final String DOMAIN_NAME = "sandbox8fb7696a9dc145e3a2cf8e0d08048144.mailgun.org";
	private static final String API_KEY_MG = "dd6e29089dc49d0e2538186aa9c536b0-afab6073-817d6eff";
	private static final String API_KEY = "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";

	private ServicioEnvioCorreos() {
		throw new IllegalStateException("ServicioEnvioCorreos class");
	}

	public static class MGSample {
		
		private MGSample() {
			throw new IllegalStateException("MGSample class");
		}

		public static JsonNode sendSimpleMessage(String correo, String nuevaClave) throws UnirestException {

			HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + DOMAIN_NAME + "/messages")
					.basicAuth("api", API_KEY_MG).field("from", "Excited User <USER@YOURDOMAIN.COM>")
					.field("to", correo).field("subject", "Cambio de clave FERTIAPP")
					.field("text", "NUEVA CLAVE: " + nuevaClave).asJson();

			return request.getBody();
		}


	}

	public static class EnviarCorreoSG {
		
		private EnviarCorreoSG() {
			throw new IllegalStateException("EnviarCorreoSG class");
		}

		public static void enviarCorreo(String correo, String nuevaClave) throws IOException {
			Email from = new Email("app138744986@heroku.com");
			String subject = "Cambio de clave FERTIAPP";
			Email to = new Email(correo);
			Content content = new Content("text/plain",  "NUEVA CLAVE: " + nuevaClave);
			Mail mail = new Mail(from, subject, to, content);

			SendGrid sg = new SendGrid(API_KEY);
			Request request = new Request();
			try {
				request.method = Method.POST;
				request.endpoint = "mail/send";
				request.body = mail.build();
				Response response = sg.api(request);
				System.out.println(response.statusCode);
				System.out.println(response.body);
				System.out.println(response.headers);
			} catch (IOException ex) {
				throw ex;
			}
		}

	}
}