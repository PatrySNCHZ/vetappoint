package es.vetappoint.controllers;


import java.util.Map;

import es.vetappoint.dao.TratamientoDao;
import es.vetappoint.entities.Opinion;
import es.vetappoint.entities.Tratamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TratamientoController {
    @Autowired
    @Qualifier("TratamientoDaoJPA")
    private TratamientoDao tratamientoDao;

    public void TratamientoController() {
    }

    @GetMapping({"/listaTratamiento"})
    public String litarTodos(Model modelo) {
        modelo.addAttribute("titulopes", "Tratamientos");
        modelo.addAttribute("titulo", "Listado de Tratamientos");
        modelo.addAttribute("tratamiento", this.tratamientoDao.findAll());
        return "lista_tratamientos";
    }

    @GetMapping({"/tratamiento/{id}"})
    public String editar(@PathVariable("id") Long id, Map<String, Object> modelo) {
        modelo.put("titulopes", "tratamiento");
        modelo.put("titulo", "Perfil de tratamiento");
        Tratamiento tratamiento = null;
        if (id > 0L) {
            tratamiento = this.tratamientoDao.findOne(id);
            modelo.put("tratamiento", tratamiento);
            return "form_tratamiento";
        } else {
            return "redirect:/listaTratamiento";
        }
    }

    @GetMapping({"/eliminar/tratamiento/{id}"})
    public String borrar(@PathVariable("id") Long id, Model modelo) {

        tratamientoDao.delete(id);

        return "redirect:/lista_tratamientos";
    }

    @RequestMapping(value ="/guardar/tratamiento", method = RequestMethod.POST)
    public String guardar(Tratamiento tratamiento, Model model){

        tratamientoDao.save(tratamiento);
        return "redirect:/listatratamientos";
    }
}
