package es.vetappoint.controllers;

import es.vetappoint.dao.EspecialidadDao;
import es.vetappoint.dao.UsuarioDao;
import es.vetappoint.entities.Especialidad;
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
public class EspecialidadController {

    @Autowired
    @Qualifier("EspecialidadDaoJPA")
    private EspecialidadDao especialidadDao;

    @GetMapping("/listaespecialidades")
    public String listaTodas(Model modelo) {
        modelo.addAttribute("titulopest", "Especialidad");
        modelo.addAttribute("titulo", "Listado de especialidades");
        modelo.addAttribute("especialidades", especialidadDao.findAll());
        return "lista_especialidades";
    }

    @GetMapping({"/especialidad/{id}"})
    public String editar(@PathVariable("id") Long id, Map<String, Object> modelo) {
        modelo.put("titulopest", "Especialidad");
        modelo.put("titulo", "Especialidad");
        Especialidad especialidad = null;
        if (id > 0L) {
            especialidad = this.especialidadDao.findOne(id);
            modelo.put("especialidad", especialidad);
            return "form_especialidad";
        } else {
            return "redirect:/listaespecialidades";
        }
    }

    @GetMapping({"/eliminar/especialidad/{id}"})
    public String borrar(@PathVariable("id") Long id, Model modelo) {

        especialidadDao.delete(id);

        return "redirect:/listaespecialidades";
    }

    @RequestMapping(value ="/guardar/especialidad", method = RequestMethod.POST)
    public String guardar(Especialidad especialidad, Model model){

        especialidadDao.save(especialidad);
        return "redirect:/listaespecialidades";
    }
}
