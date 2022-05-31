package es.vetappoint.controllers;

import es.vetappoint.dao.ClinicaDao;
import es.vetappoint.dao.OpinionDao;
import es.vetappoint.dao.UsuarioDao;
import es.vetappoint.entities.Clinica;
import es.vetappoint.entities.Mascota;
import es.vetappoint.entities.Opinion;
import es.vetappoint.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class OpinionController {

    @Autowired
    @Qualifier("OpinionDaoJPA")
    private OpinionDao opinionDao;

    @Autowired
    @Qualifier("UsuarioDaoJPA")
    private UsuarioDao usuarioDao;

    @Autowired
    @Qualifier("ClinicaDaoJPA")
    private ClinicaDao clinicaDao;


    @GetMapping("/listaopiniones")
    public String listaTodas(Model modelo) {
        modelo.addAttribute("titulopest", "Opinion");
        modelo.addAttribute("titulo", "Listado de opiniones");
        modelo.addAttribute("opiniones", opinionDao.findAll());
        return "lista_opiniones";
    }

    @GetMapping({"/opinion/{id}"})
    public String editar(@PathVariable("id") Long id, Map<String, Object> modelo) {
        modelo.put("titulopest", "Opinion");
        modelo.put("titulo", "Perfil de opinion");
        Opinion opinion = null;
        if (id > 0L) {
            opinion = this.opinionDao.findOne(id);
            modelo.put("opinion", opinion);
            return "form_opinion";
        } else {
            return "redirect:/listaopiniones";
        }
    }

    @GetMapping({"/eliminar/opinion/{id}"})
    public String borrar(@PathVariable("id") Long id, Model modelo) {

        opinionDao.delete(id);

        return "redirect:/listaopiniones";
    }

    @RequestMapping(value ="/guardar/opinion", method = RequestMethod.POST)
    public String guardar(Opinion opinion, Model model){

        opinionDao.save(opinion);
        return "redirect:/listaopiniones";
    }

    @GetMapping("/opinion/clinica/{id}")
    public String listarOpinionPorClinica(@PathVariable("id") Long id, Model modelo) {
        Clinica clinica = clinicaDao.findOne(id);
        modelo.addAttribute("titulopes", "Opiniones");
        modelo.addAttribute("titulo", "Las opiniones de los usuarios sobre" + clinica.getNombre());
        modelo.addAttribute("opiniones", opinionDao.listByClinica(clinica));
        return "lista_opiniones";
    }

    @GetMapping("/opinion/usuario/{id}")
    public String listarOpinionPorUsuario(@PathVariable("id") Long id, Model modelo) {
        Usuario usuario = usuarioDao.findOne(id);
        modelo.addAttribute("titulopes", "Tus opiniones");
        modelo.addAttribute("titulo", "Hola, " + usuario.getNombre() + " aquí están tus valoraciones");
        modelo.addAttribute("opiniones", opinionDao.listByUsuario(usuario));
        return "lista_opiniones";
    }

}
