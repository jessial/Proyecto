package FertiWebBackEnd.FertiWeb;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import controladores.ControladorDatos;

@SpringBootApplication
@ComponentScan(basePackages = { "servicios" })
@EntityScan("persistencia.entidad")
@EnableJpaRepositories("persistencia.repositorio") 
public class FertiWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(FertiWebApplication.class, args);
	}

	@Bean
	public ControladorDatos creaControladorDatos() {
		return new ControladorDatos();
	}
	
	@Bean
	public DozerBeanMapper creaDozerBeanMapper() {
		return new DozerBeanMapper();
	}
	
}
