package es.vetappoint.config;
/*
import org.grupoplan.qplan.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig_grupo4 extends WebSecurityConfigurerAdapter {

    //Necesario para evitar que la seguridad se aplique a los resources
    //Como los css, imagenes y javascripts

    String[] resources = new String[]{
            "/plugins/", "/css/", "/js/", "/img/", "/data/**","/assets/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers(resources).permitAll()
                .antMatchers("/", "/index*", "/eventos*","/contacto*", "/registro*").permitAll()
                .antMatchers("/administracion*").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/perfil").access("hasRole('ROLE_CLIENTE') or hasRole('ROLE_ANUNCIANTE')")
                .antMatchers("/eventos/editar_evento*").access("hasRole('ROLE_ANUNCIANTE') or hasRole('ROLE_ADMIN')")
                .anyRequest().authenticated();
        http.formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/index")
                .failureUrl("/login?error=true")
                .usernameParameter("email")
                .passwordParameter("password");
        http.logout()
                .permitAll()
                .logoutSuccessUrl("/login?logout");
    }

    BCryptPasswordEncoder bCryptPasswordEncoder;
    //Crea el encriptador de contraseÃ±as

    public BCryptPasswordEncoder passwordEncoder() {
        bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
    //El numero 4 representa que tan fuerte quieres la encriptacion.
    //Se puede en un rango entre 4 y 31.

        return bCryptPasswordEncoder;
    }

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    //Registra el service para usuarios y el encriptador de contrasena
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        // Setting Service to find User in the database.
        // And Setting PassswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}
*/
