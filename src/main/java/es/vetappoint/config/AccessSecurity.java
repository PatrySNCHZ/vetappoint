package es.vetappoint.config;

import es.vetappoint.dao.ClinicaDao;
import es.vetappoint.dao.UsuarioDao;
import es.vetappoint.entities.Clinica;
import es.vetappoint.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AccessSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private Clinica clinica;

    @Autowired
    private Usuario usuario;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/inicio", "/login").permitAll()
                .antMatchers("/editar/clinica").hasRole(usuario.getRol())
                .antMatchers("/editar/mascotas").hasRole(clinica.getRol())
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .loginPage("/login")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/inicio")
                .permitAll();
    }
}
