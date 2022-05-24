package es.vetappoint.controllers;


import es.vetappoint.dao.VeterinarioDao;

import es.vetappoint.entities.Mascota;
import es.vetappoint.entities.Veterinario;
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
public class VeterinarioController {
    @Autowired
    @Qualifier("VeterinarioDaoJPA")
    private VeterinarioDao veterinarioDao;

    @GetMapping("/listaveterinarios")
    public String listaTodas(Model modelo) {
        modelo.addAttribute("titulopest", "Veterinario");
        modelo.addAttribute("titulo", "Listado de veterinario");
        modelo.addAttribute("veterinario", veterinarioDao.findAll());
        return "lista_veterinario";
    }

    @GetMapping({"/veterinario/{id}"})
    public String perfil(@PathVariable("id") Long id, Map<String, Object> modelo) {
        modelo.put("titulopest", "Veterinario");
        modelo.put("titulo", "Perfil de veterinario");
        Veterinario veterinario = null;
        if (id > 0L) {
            veterinario = this.veterinarioDao.findOne(id);
            modelo.put("veterinario", veterinario);
            return "veterinario_perfil";
        } else {
            return "redirect:/listaveterinario";
        }
    }

    @GetMapping("/editar/veterinario/{id}")
    public String editar(@PathVariable("id") Long id, Map<String, Object> modelo) {
        modelo.put("titulopes", "Veterinario");
        modelo.put("titulo", "Perfil veterinario");
        Veterinario veterinario = null;
        if (id > 0L) {
            veterinario = this.veterinarioDao.findOne(id);
            modelo.put("veterinario", veterinario);
            return "form_veterinario";
        } else {
            return "redirect:/listaveterinarios";
        }
    }

    @GetMapping({"/eliminar/veterinario/{id}"})
    public String borrar(@PathVariable("id") Long id, Model modelo) {

        veterinarioDao.delete(id);

        return "redirect:/listaveterinarios";
    }

    @RequestMapping(value ="/guardar/veterinario", method = RequestMethod.POST)
    public String guardar(Veterinario veterinario, Model model){

        veterinarioDao.save(veterinario);

        return "redirect:/listaveterinarios";
    }





}
