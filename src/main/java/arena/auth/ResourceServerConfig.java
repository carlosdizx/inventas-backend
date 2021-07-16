package arena.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter
{
    @Override
    public void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
        /**
        .antMatchers(HttpMethod.DELETE,"/api/productos/{id}").hasRole("ADMIN")
        .antMatchers(HttpMethod.DELETE,"/api/clientes/{id}").hasRole("ADMIN")
        .antMatchers(HttpMethod.DELETE,"/api/facturas/{id}").hasRole("ADMIN")
        .antMatchers(HttpMethod.GET,"/api/facturas/all").hasRole("ADMIN")
        .antMatchers(HttpMethod.GET,"/api/facturas/{id}").hasRole("ADMIN")
        .antMatchers(HttpMethod.GET,"/api/facturas/get/cliente/{documento}").hasRole("ADMIN")
         */
        .anyRequest().authenticated();
    }
}
