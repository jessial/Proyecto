package configuracion.spring;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import controladores.ControladorDatosAnalisis;
import controladores.ControladorDatosElemento;
import controladores.ControladorDatosElementoXAnalisis;
import controladores.ControladorDatosFuente;
import controladores.ControladorDatosLugar;
import controladores.ControladorDatosParcela;
import controladores.ControladorDatosRequerimiento;
import controladores.ControladorDatosRol;
import controladores.ControladorDatosTipoCultivo;
import controladores.ControladorDatosTipoFuente;
import controladores.ControladorDatosUnidad;
import controladores.ControladorDatosUsuario;
import controladores.ControladorDeDatosRecomendacion;
import controladores.ControladorSeguridad;

@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages = { "servicios", "configuracion.seguridad" })
@EntityScan("persistencia.entidad")
@EnableJpaRepositories("persistencia.repositorio")
public class FertiWebApplication implements CommandLineRunner{
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(FertiWebApplication.class, args);
	}

	@Bean
	public ControladorSeguridad crearControladorSeguridad() {
		return new ControladorSeguridad();
	}

	@Bean
	public DozerBeanMapper crearDozerBeanMapper() {
		return new DozerBeanMapper();
	}

	@Bean
	public ControladorDatosElemento crearControladorDatosElemento() {
		return new ControladorDatosElemento();
	}

	@Bean
	public ControladorDatosFuente crearControladorDatosFuente() {
		return new ControladorDatosFuente();
	}

	@Bean
	public ControladorDatosRequerimiento crearControladorDatosRequerimiento() {
		return new ControladorDatosRequerimiento();
	}

	@Bean
	public ControladorDatosRol crearControladorDatosRol() {
		return new ControladorDatosRol();
	}

	@Bean
	public ControladorDatosTipoCultivo crearControladorDatosTipoCultivo() {
		return new ControladorDatosTipoCultivo();
	}

	@Bean
	public ControladorDatosTipoFuente crearControladorDatosTipoFuente() {
		return new ControladorDatosTipoFuente();
	}

	@Bean
	public ControladorDatosUnidad crearControladorDatosUnidad() {
		return new ControladorDatosUnidad();
	}

	@Bean
	public ControladorDatosLugar crearControladorDatosLugar() {
		return new ControladorDatosLugar();
	}

	@Bean
	public ControladorDatosUsuario crearControladorDatosUsuario() {
		return new ControladorDatosUsuario();
	}

	@Bean
	public ControladorDatosAnalisis crearControladorDatosAnalisis() {
		return new ControladorDatosAnalisis();
	}

	@Bean
	public ControladorDatosParcela crearControladorDatosParcela() {
		return new ControladorDatosParcela();
	}

	@Bean
	public ControladorDatosElementoXAnalisis crearControladorDatosElementoXAnalisis() {
		return new ControladorDatosElementoXAnalisis();
	}

	@Bean
	public ControladorDeDatosRecomendacion crearControladorDeDatosRecomendacion() {
		return new ControladorDeDatosRecomendacion();
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
