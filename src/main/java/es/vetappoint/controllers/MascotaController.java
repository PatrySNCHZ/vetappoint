package es.vetappoint.controllers;

import es.vetappoint.dao.MascotaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MascotaController {

    @Autowired
    @Qualifier("mascotaDAOJPA")
    private MascotaDAO mascotaDAO;

    @GetMapping("/listamascotas")
    public String listarMascotas(Model modelo){
        modelo.addAttribute("titulo", "Listado de Mascotas");
        modelo.addAttribute("mascotas", mascotaDAO.findAll());
        return "lista_mascotas";
    }

}
