package groupe1.filrouge.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import groupe1.filrouge.security.service.AppAuthProvider;
import groupe1.filrouge.security.service.ServiceUtilisateurImpl;

@Configuration
@EnableGlobalMethodSecurity(
		securedEnabled = true,
		jsr250Enabled = true,
		prePostEnabled = true) 
@EnableWebSecurity
@EnableWebMvc /**Gestion du MVC Web pour les WAR et les JSP **/
public class SecurityConfig 
extends WebSecurityConfigurerAdapter 
implements WebMvcConfigurer{
	@Autowired
	ServiceUtilisateurImpl userDetailsService;

    
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf()
                .disable()
                .exceptionHandling()
                .and()
                .authenticationProvider(getProvider())
                .formLogin()
                .loginPage("/login")
                .and()
                .logout()
                .logoutUrl("/logout")
                .invalidateHttpSession(true)
                .and()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/logout").permitAll()
                .antMatchers("/").authenticated()
                .anyRequest().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/img/**",
                "/css/**",
                "/js/**")
                .addResourceLocations(
                        "classpath:/static/img/",
                        "classpath:/static/css/",
                        "classpath:/static/js/");
    }

        
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
     /**
     * Configuration des chemins par défaut pour le menu et le formulaire
     * de connexion.
     */
       registry.addViewController("/").setViewName("home");
       registry.addViewController("/login").setViewName("login");
      
    }
     
    @Bean
    public AuthenticationProvider getProvider() {
    	AppAuthProvider provider = new AppAuthProvider();
        provider.setUserDetailsService(userDetailsService);
        return provider;

    }
}
