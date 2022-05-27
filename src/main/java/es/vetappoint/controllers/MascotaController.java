package es.vetappoint.controllers;

import es.vetappoint.dao.MascotaDao;
import es.vetappoint.dao.UsuarioDao;
import es.vetappoint.entities.Mascota;
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
public class MascotaController {

    @Autowired
    @Qualifier("mascotaDAOJPA")
    private MascotaDao mascotaDAO;

    @Autowired
    @Qualifier("UsuarioDaoJPA")
    private UsuarioDao usuarioDao;

    @GetMapping("/listamascotas")
    public String listarMascotas(Model modelo){
        modelo.addAttribute("titulo", "Listado de Mascotas");
        modelo.addAttribute("mascotas", mascotaDAO.findAll());
        return "mascotas/lista_mascotas";
    }

    @GetMapping("/editar/mascota/{id}")
    public String editar(@PathVariable("id") Long id, Map<String, Object> modelo) {
        modelo.put("titulopes", "Mascota");
        modelo.put("titulo", "Perfil mascota");
        Mascota mascota = null;
        if (id > 0L) {
            mascota = this.mascotaDAO.findOne(id);
            modelo.put("mascota", mascota);
            return "mascotas/form_mascota";
        } else {
            return "redirect:/mascotas/listamascotas";
        }
    }

    @GetMapping("/mascota/{id}")
    public String perfil(@PathVariable("id") Long id, Map<String, Object> modelo) {
        modelo.put("titulopes", "Perfil de clinica");
        modelo.put("titulo", "Bienvenido/a al perfil de " + mascotaDAO.findOne(id).getNombre());
        Mascota mascota = null;
        if (id > 0L) {
            mascota = this.mascotaDAO.findOne(id);
            modelo.put("mascota", mascota);
            return "mascotas/mascota_perfil";
        } else {
            return "redirect:/mascotas/listamascotas";
        }
    }


    @GetMapping("/listamascotas/{id}")
    public String listaMascotasPorUsuario(@PathVariable("id") Long id, Model modelo) {
        Usuario usuario = usuarioDao.findOne(id);
        modelo.addAttribute("titulo", "Tus mascotas");
        modelo.addAttribute("titulopes", "Bienvenido/a al perfil de " + usuario.getNombre());
        modelo.addAttribute("mascotas", mascotaDAO.listByUserId(usuario));
        return "mascotas/lista_mascotas";
    }



    @GetMapping({"/eliminar/mascota/{id}"})
    public String borrar(@PathVariable("id") Long id, Model modelo) {

        mascotaDAO.delete(id);

        return "redirect:/mascotas/listamascotas";
    }


    @RequestMapping(value ="/guardar/mascota", method = RequestMethod.POST)
    public String guardar(Mascota mascota, Model model){

        mascotaDAO.save(mascota);

        return "redirect:/mascotas/listamascotas";
    }




}
