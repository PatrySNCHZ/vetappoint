package es.vetappoint.controllers;

import java.util.Map;

import es.vetappoint.dao.LineasTratamientoDao;
import es.vetappoint.entities.LineasTratamiento;
import es.vetappoint.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LineasTratamientoController {
    @Autowired
    @Qualifier("LineasTratamientoDaoJPA")
    private LineasTratamientoDao lineasTratamientoDao;

    public void LineasTratamientoController() {
    }

    @GetMapping({"/listalintrata"})
    public String litarTodos(Model modelo) {
        modelo.addAttribute("titulopes", "LineasTratamientos");
        modelo.addAttribute("titulo", "Listado de LineasTratamientos");
        modelo.addAttribute("lineas_tratamiento", this.lineasTratamientoDao.findAll());
        return "lista_lineastratamiento";
    }

    @GetMapping({"/lineas_tratamiento/{id}"})
    public String editar(@PathVariable("id") Long id, Map<String, Object> modelo) {
        modelo.put("titulopes", "lineas_tratamiento");
        modelo.put("titulo", "Perfil de lineas_tratamiento");
        LineasTratamiento lineas_tratamiento = null;
        if (id > 0L) {
            lineas_tratamiento = this.lineasTratamientoDao.findOne(id);
            modelo.put("lineas_tratamiento", lineas_tratamiento);
            return "form_lineas_tratamiento";
        } else {
            return "redirect:/listalintrata";
        }
    }

    @GetMapping({"/eliminar/lineas_tratamiento/{id}"})
    public String borrar(@PathVariable("id") Long id, Model modelo) {

        lineasTratamientoDao.delete(id);

        return "redirect:/listalintrata";
    }

    @RequestMapping(value ="/guardar/lineas_tratamiento", method = RequestMethod.POST)
    public String guardar(LineasTratamiento lineasTratamiento, Model model){

        lineasTratamientoDao.save(lineasTratamiento);
        return "redirect:/listalintrata";
    }
}
