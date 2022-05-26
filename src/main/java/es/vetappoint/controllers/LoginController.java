package es.vetappoint.controllers;

import es.vetappoint.dao.ClinicaDao;
import es.vetappoint.dao.UsuarioDao;
import es.vetappoint.entities.Clinica;
import es.vetappoint.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    @Qualifier("UsuarioDaoJPA")
    private UsuarioDao usuarioDao;
    @Autowired
    @Qualifier("ClinicaDaoJPA")
    private ClinicaDao clinicaDao;

    @GetMapping("/login")
    public String inicio(Model modelo){
        modelo.addAttribute("titulopest", "Acceso");
        modelo.addAttribute("titulo", "Identifíquese para acceder");
        return "login";
    }

    @PostMapping("/login")
    public String acceso(
            @RequestParam("usuario") String email,
            @RequestParam("clave") String clave,
            @RequestParam(name="esclinica", required = false) String esclinica,
            Model modelo) {
            if(esclinica != null) {


                Optional<Clinica> clin = clinicaDao.findByEmail(email);
                if(clin.isPresent() && clave.equals((clin.get().getClave()))) {

                    return "redirect:/clinica/" + clin.get().getId();

                }
            } else {
                Optional<Usuario> usu = usuarioDao.findByEmail(email);
                if(usu.isPresent() && clave.equals(usu.get().getClave())) {

                    return "redirect:/usuario/" + usu.get().getId();

                }
            }
        return "redirect:/login";
    }


}
