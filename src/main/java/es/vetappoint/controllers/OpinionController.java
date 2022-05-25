package es.vetappoint.controllers;

import es.vetappoint.dao.OpinionDao;
import es.vetappoint.dao.UsuarioDao;
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

    @GetMapping("/listaopinion")
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
            return "redirect:/lista_opinion";
        }
    }

    @GetMapping({"/eliminar/opinion/{id}"})
    public String borrar(@PathVariable("id") Long id, Model modelo) {

        opinionDao.delete(id);

        return "redirect:/lista_opiniones";
    }

    @RequestMapping(value ="/guardar/opinion", method = RequestMethod.POST)
    public String guardar(Opinion opinion, Model model){

        opinionDao.save(opinion);
        return "redirect:/listaopiniones";
    }
}
