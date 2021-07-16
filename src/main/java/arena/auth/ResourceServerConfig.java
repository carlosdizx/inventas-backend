package arena.auth;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

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
        .anyRequest().authenticated()
        .and().cors().configurationSource(corsConfigurationSource());
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","DELETE","PUT","OPTIONS"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("Content_Type","Authorization"));

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public FilterRegistrationBean<org.springframework.web.filter.CorsFilter> corsFilter(){
        FilterRegistrationBean<org.springframework.web.filter.CorsFilter> bean = new FilterRegistrationBean(new CorsFilter(corsConfigurationSource()));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
