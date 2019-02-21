package configuracion.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableResourceServer
public class ServidorRecursosConfiguracion extends ResourceServerConfigurerAdapter{
	
	@Autowired
	CorsConfigurationSource corsConfigurationSource;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		//.antMatchers("/login").permitAll()
		.anyRequest().permitAll().and().cors();
		
		 http.headers().frameOptions().disable();
	     http.authorizeRequests().antMatchers("/h2-console/**").permitAll();

	}

}
