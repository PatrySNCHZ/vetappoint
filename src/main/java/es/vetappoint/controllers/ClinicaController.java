package es.vetappoint.controllers;

import es.vetappoint.dao.ClinicaDao;
import es.vetappoint.entities.Clinica;
import java.util.Map;

import es.vetappoint.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class ClinicaController {
    @Autowired
    @Qualifier("ClinicaDaoJPA")
    private ClinicaDao clinicaDao;


    @GetMapping("/listaclinicas")
    public String listarClinicas(Model modelo) {
        modelo.addAttribute("titulopes", "Clinicas");
        modelo.addAttribute("titulo", "Listado de Clinicas");
        modelo.addAttribute("clinicas", clinicaDao.findAll());
        return "clinicas/lista_clinicas";
    }

    @GetMapping("/editar/clinica/{id}")
    public String editar(@PathVariable("id") Long id, Map<String, Object> modelo) {
        modelo.put("titulopes", "Editar clinica");
        modelo.put("titulo", "Editar perfil " +  clinicaDao.findOne(id).getNombre());
        Clinica clinica = null;
        if (id > 0L) {
           clinica = this.clinicaDao.findOne(id);
            modelo.put("clinica", clinica);
            return "clinicas/form_clinica";
        } else {
            return "redirect:/listaclinicas";
        }
    }

    @GetMapping("/clinica/{id}")
    public String perfil(@PathVariable("id") Long id, Map<String, Object> modelo) {
        modelo.put("titulopes", "Perfil de clinica");
        modelo.put("titulo", "Bienvenido/a al perfil de " + clinicaDao.findOne(id).getNombre());
        Clinica clinica = null;
        if (id > 0L) {
            clinica = this.clinicaDao.findOne(id);
            modelo.put("clinica", clinica);
            return "clinicas/clinica_perfil";
        } else {
            return "redirect:/listaclinicas";
        }
    }

    @GetMapping({"/eliminar/clinica/{id}"})
    public String borrar(@PathVariable("id") Long id, Model modelo) {

            clinicaDao.delete(id);

        return "redirect:/listaclinicas";
    }



    @GetMapping(value ="/registrar/clinica")
    public String registro(Model model){
        model.addAttribute("titulo", "Registro");
        return "clinicas/registro_clinica";
    }

    @RequestMapping(value ="/guardar/clinica", method = RequestMethod.POST)
    public String guardar(Clinica clinica, Model model){

        model.addAttribute("clinica", clinicaDao.save(clinica));

        return "redirect:/listaclinicas";
    }


}
