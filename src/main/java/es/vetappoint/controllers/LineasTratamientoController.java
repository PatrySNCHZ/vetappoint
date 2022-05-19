package es.vetappoint.controllers;

import es.vetappoint.dao.IfxLineasTratamientoDao;

import java.util.Map;

import es.vetappoint.entities.LineasTratamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LineasTratamientoController {
    @Autowired
    @Qualifier("LineasTratamientoDaoJPA")
    private IfxLineasTratamientoDao LineasTratamientoDao;

    public void LineasTratamientoController() {
    }

    @GetMapping({"/listaLineasTratamiento"})
    public String litarTodos(Model modelo) {
        modelo.addAttribute("titulopes", "LineasTratamientos");
        modelo.addAttribute("titulo", "Listado de LineasTratamientos");
        modelo.addAttribute("lineas_tratamiento", this.LineasTratamientoDao.findAll());
        return "lista_lineas_tratamiento";
    }

    @GetMapping({"/lineas_tratamiento/{id}"})
    public String editar(@PathVariable("id") Long id, Map<String, Object> modelo) {
        modelo.put("titulopes", "lineas_tratamiento");
        modelo.put("titulo", "Perfil de lineas_tratamiento");
        LineasTratamiento lineas_tratamiento = null;
        if (id > 0L) {
            lineas_tratamiento = this.LineasTratamientoDao.findOne(id);
            modelo.put("lineas_tratamiento", lineas_tratamiento);
            return "form_lineas_tratamiento";
        } else {
            return "redirect:/listaLineasTratamiento";
        }
    }
}
