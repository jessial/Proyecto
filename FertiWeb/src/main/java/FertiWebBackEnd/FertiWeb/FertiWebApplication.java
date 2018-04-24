package FertiWebBackEnd.FertiWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("persistencia.entidad")
public class FertiWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(FertiWebApplication.class, args);
	}
}
