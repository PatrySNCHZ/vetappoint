package es.vetappoint.controllers;


import es.vetappoint.dao.VeterinarioDao;

import es.vetappoint.entities.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

public class VeterinarioController {
    @Autowired
    @Qualifier("VeterinarioDaoJPA")
    private VeterinarioDao veterinarioDao;

    @GetMapping("/listaveterinario")
    public String listaTodas(Model modelo) {
        modelo.addAttribute("titulopest", "Veterinario");
        modelo.addAttribute("titulo", "Listado de veterinario");
        modelo.addAttribute("veterinario", veterinarioDao.findAll());
        return "lista_veterinario";
    }

    @GetMapping({"/veterinario/{id}"})
    public String editar(@PathVariable("id") Long id, Map<String, Object> modelo) {
        modelo.put("titulopest", "Veterinario");
        modelo.put("titulo", "Perfil de veterinario");
        Veterinario veterinario = null;
        if (id > 0L) {
            veterinario = this.veterinarioDao.findOne(id);
            modelo.put("veterinario", veterinario);
            return "form_veterinario";
        } else {
            return "redirect:/listaveterinario";
        }
    }
}
