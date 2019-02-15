package configuracion.seguridad;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ServidorRecursosConfiguracion extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		//.antMatchers("/login").permitAll()
		.anyRequest().permitAll().and().cors();
		
		 http.headers().frameOptions().disable();
	     http.authorizeRequests().antMatchers("/h2-console/**").permitAll();
	}

}
