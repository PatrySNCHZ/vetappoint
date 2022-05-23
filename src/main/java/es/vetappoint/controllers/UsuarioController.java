package es.vetappoint.controllers;

import es.vetappoint.dao.UsuarioDao;
import es.vetappoint.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@Controller
public class UsuarioController {

    @Autowired
    @Qualifier("UsuarioDaoJPA")
    private UsuarioDao usuarioDao;

    @GetMapping("/listausuarios")
    public String listaTodas(Model modelo) {
        modelo.addAttribute("titulo", "Listado de usuarios");
        modelo.addAttribute("usuarios", usuarioDao.findAll());
        return "lista_usuarios";
    }

    @GetMapping({"/editar/usuario/{id}"})
    public String editar(@PathVariable("id") Long id, Map<String, Object> modelo) {
        modelo.put("titulopest", "Usuario");
        modelo.put("titulo", "Editar usuario");
        Usuario usuario = null;
        if (id > 0L) {
            usuario = this.usuarioDao.findOne(id);
            modelo.put("usuario", usuario);
            return "form_usuario";
        } else {
            return "redirect:/listausuarios";
        }
    }

    @GetMapping({"/usuario/{id}"})
    public String perfil(@PathVariable("id") Long id, Map<String, Object> modelo) {
        modelo.put("titulopest", "Usuario");
        modelo.put("titulo", "Perfil de usuario");
        Usuario usuario = null;
        if (id > 0L) {
            usuario = this.usuarioDao.findOne(id);
            modelo.put("usuario", usuario);
            return "usuario_perfil";
        } else {
            return "redirect:/listausuarios";
        }
    }


    @GetMapping({"/eliminar/usuario/{id}"})
    public String borrar(@PathVariable("id") Long id, Model modelo) {

        usuarioDao.delete(id);

        return "redirect:/listausuarios";
    }
}