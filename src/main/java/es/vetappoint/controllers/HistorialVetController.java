package es.vetappoint.controllers;

import es.vetappoint.dao.HistorialVetDao;
import es.vetappoint.dao.UsuarioDao;
import es.vetappoint.entities.HistorialVet;
import es.vetappoint.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@Controller
public class HistorialVetController {

    @Autowired
    @Qualifier("HistorialVetDaoJPA")
    private HistorialVetDao historialVetDao;

    @GetMapping("/listahistorialvet")
    public String listaTodas(Model modelo) {
        modelo.addAttribute("titulopest", "HistorialVet");
        modelo.addAttribute("titulo", "Listado de historiales veterinarios");
        modelo.addAttribute("usuarios", historialVetDao.findAll());
        return "lista_historialesvet";
    }

    @GetMapping({"/historialvet/{id}"})
    public String editar(@PathVariable("id") Long id, Map<String, Object> modelo) {
        modelo.put("titulopest", "HistorialVet");
        modelo.put("titulo", "Historiales veterinarios");
        HistorialVet historialVet = null;
        if (id > 0L) {
            historialVet = this.historialVetDao.findOne(id);
            modelo.put("historialvet", historialVet);
            return "form_historialvet";
        } else {
            return "redirect:/listahistorialvet";
        }
    }
}
