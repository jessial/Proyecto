package configuracion.spring;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import controladores.ControladorDatos;
import controladores.ControladorDatosApp;
import controladores.ControladorSeguridad;

@SpringBootApplication
@ComponentScan(basePackages = { "servicios", "configuracion.seguridad"})
@EntityScan("persistencia.entidad")
@EnableJpaRepositories("persistencia.repositorio") 
public class FertiWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(FertiWebApplication.class, args);
	}

	@Bean
	public ControladorDatos crearControladorDatos() {
		return new ControladorDatos();
	}
	
	@Bean
	public ControladorDatosApp crearControladorDatosApp() {
		return new ControladorDatosApp();
	}
	
	@Bean
	public ControladorSeguridad crearControladorSeguridad() {
		return new ControladorSeguridad();
	}
	
	@Bean
	public DozerBeanMapper crearDozerBeanMapper() {
		return new DozerBeanMapper();
	}
	
}
