package es.vetappoint.controllers;


import es.vetappoint.dao.IfxTratamientoDao;

import java.util.Map;

import es.vetappoint.entities.Tratamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TratamientoController {
    @Autowired
    @Qualifier("TratamientoDaoJPA")
    private IfxTratamientoDao TratamientoDao;

    public void TratamientoController() {
    }

    @GetMapping({"/listaTratamiento"})
    public String litarTodos(Model modelo) {
        modelo.addAttribute("titulopes", "Tratamientos");
        modelo.addAttribute("titulo", "Listado de Tratamientos");
        modelo.addAttribute("tratamiento", this.TratamientoDao.findAll());
        return "lista_tratamientos";
    }

    @GetMapping({"/tratamiento/{id}"})
    public String editar(@PathVariable("id") Long id, Map<String, Object> modelo) {
        modelo.put("titulopes", "tratamiento");
        modelo.put("titulo", "Perfil de tratamiento");
        Tratamiento tratamiento = null;
        if (id > 0L) {
            tratamiento = this.TratamientoDao.findOne(id);
            modelo.put("tratamiento", tratamiento);
            return "form_tratamiento";
        } else {
            return "redirect:/listaTratamiento";
        }
    }
}
