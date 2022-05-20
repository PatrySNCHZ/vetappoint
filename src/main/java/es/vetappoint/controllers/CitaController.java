package es.vetappoint.controllers;

import es.vetappoint.dao.CitaDao;
import es.vetappoint.dao.UsuarioDao;
import es.vetappoint.entities.Cita;
import es.vetappoint.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@Controller
public class CitaController {

    @Autowired
    @Qualifier("CitaDaoJPA")
    private CitaDao citaDao;

    @GetMapping("/listacitas")
    public String listaTodas(Model modelo) {
        modelo.addAttribute("titulopest", "Cita");
        modelo.addAttribute("titulo", "Listado de citas");
        modelo.addAttribute("citas", citaDao.findAll());
        return "lista_citas";
    }

    @GetMapping({"/cita/{id}"})
    public String editar(@PathVariable("id") Long id, Map<String, Object> modelo) {
        modelo.put("titulopest", "Cita");
        modelo.put("titulo", "Perfil de cita");
        Cita cita = null;
        if (id > 0L) {
            cita = this.citaDao.findOne(id);
            modelo.put("cita", cita);
            return "form_cita";
        } else {
            return "redirect:/listacita";
        }
    }
}
