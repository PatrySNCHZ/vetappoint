package es.vetappoint.controllers;

import es.vetappoint.dao.ClinicaDao;
import es.vetappoint.entities.Clinica;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
        return "lista_clinicas";
    }

    @GetMapping("/clinica/{id}")
    public String editar(@PathVariable("id") Long id, Map<String, Object> modelo) {
        modelo.put("titulopes", "Clinica");
        modelo.put("titulo", "Perfil de clinica");
        Clinica clinica = null;
        if (id > 0L) {
           clinica = this.clinicaDao.findOne(id);
            modelo.put("clinica", clinica);
            return "form_clinica";
        } else {
            return "redirect:/listaClinica";
        }
    }
}
