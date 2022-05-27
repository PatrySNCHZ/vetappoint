package es.vetappoint.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.grupoplan.qplan.dto.AnuncianteClienteDto;
import org.grupoplan.qplan.entity.*;
import org.grupoplan.qplan.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class UserController_grupo4 {



    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private CodigoPostalService codigoPostalService;

    @Autowired
    private UserService userService;

    @Autowired
    private AnuncianteService anuncianteService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registro")
    public String signup(Model model) {

        // usar DTO AnuncianteClienteDTO para enviar los datos del anunciante y cliente
        // al formulario de registro
        AnuncianteClienteDto anunciantecliente =  new AnuncianteClienteDto();
        anunciantecliente.setRole("ROLE_CLIENTE"); // para inicializar el radio button del tipo de usuario
        model.addAttribute("formregistro",anunciantecliente);

        List<CodigoPostal> cpostales = codigoPostalService.findAll();

        model.addAttribute("signup",true);
        model.addAttribute("cpostales",cpostales);
        return "sign-up";
    }

    @PostMapping("/registro")
    public String registroAct(@ModelAttribute AnuncianteClienteDto formregistro, Model model) throws ParseException {

        // Creamos una instancia de BCrypt para codificar la contraseña
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(4);

        // Creamos un usuario vacío que va a albergar la contraseña encriptada para gyuarda en la BBDD
        User user = new User();

        String claveenclaro = formregistro.getPassword(); //<-- la clave llega "en claro" en la request desde el formulario
        String claveencriptada = passwordEncoder.encode(claveenclaro); //<-- se codifica
        user.setPassword(claveencriptada); //<-- Se asigna al nuevo usuario
        // Se debería poner en una sola línea
        // user.setPassword(passwordEncoder.encode(formregistro.getPassword()));

        user.setEstadoActivo(true);
        user.setEmail(formregistro.getEmail());
        user.setTelefono(formregistro.getTelefono());
        user.setNombre(formregistro.getNombre());
        user.setApellidos(formregistro.getApellidos());


        final Authority authorityfinal = authorityService.findByAuthority(formregistro.getRole());
        List<Authority> roles = new ArrayList<>();
        roles.add(authorityfinal);
        user.setAuthority(roles);

        User savedUser = userService.save(user);

        if (formregistro.getRole().equals("ROLE_CLIENTE")) {
            Cliente cliente = new Cliente();
            String fnString = formregistro.getFechaNacimiento();
            Date fNacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(fnString);
            cliente.setUser(savedUser);
            cliente.setfechaNacimiento(fNacimiento);
            cliente.setSexo(formregistro.getSexo());
            clienteService.save(cliente);
        } else {
            Anunciante anunciante = new Anunciante();
            anunciante.setUser(savedUser);
            anunciante.setNombreLocal(formregistro.getNombreLocal());
            anunciante.setDescripcion(formregistro.getDescripcion());
            anuncianteService.save(anunciante);
        }

        return "redirect:/login";

        // TODO: modificar el return

    }

    @GetMapping(value = "/perfil/{id}")
    public String perfil() {
        return null;
    }

    @RequestMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }


}
