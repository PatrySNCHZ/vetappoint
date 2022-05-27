package es.vetappoint.controllers;

import es.vetappoint.dao.CitaDao;
import es.vetappoint.dao.ClinicaDao;
import es.vetappoint.dao.UsuarioDao;
import es.vetappoint.entities.Cita;
import es.vetappoint.entities.Clinica;
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
public class CitaController {

    @Autowired
    @Qualifier("CitaDaoJPA")
    private CitaDao citaDao;

    @Autowired
    @Qualifier("UsuarioDaoJPA")
    private UsuarioDao usuarioDao;

    @Autowired
    @Qualifier("ClinicaDaoJPA")
    private ClinicaDao clinicaDao;


    @GetMapping("/listacitas")
    public String listaTodas(Model modelo) {
        modelo.addAttribute("titulopest", "Cita");
        modelo.addAttribute("titulo", "Listado de citas");
        modelo.addAttribute("citas", citaDao.findAll());
        return "citas/lista_citas";
    }

    @GetMapping({"/cita/{id}", "/cita"})
    public String editar(@PathVariable("id") Long id, Map<String, Object> modelo) {
        modelo.put("titulopest", "Cita");
        modelo.put("titulo", "Perfil de cita");
        Cita cita = null;
        if (id > 0L) {
            cita = this.citaDao.findOne(id);
            modelo.put("cita", cita);
            return "citas/solicitar_cita";
        } else {
            return "redirect:/citas/listacitas";
        }
    }

    @GetMapping({"/eliminar/cita/{id}"})
    public String borrar(@PathVariable("id") Long id, Model modelo) {

        citaDao.delete(id);

        return "redirect:/citas/lista_citas";
    }

    @RequestMapping(value ="/guardar/cita", method = RequestMethod.POST)
    public String guardar(Cita cita, Model model){

        citaDao.save(cita);
        return "redirect:/citas/listacitas";
    }


    @GetMapping("/citas/clinica/{id}")
    public String listarCitasPorClinica(@PathVariable("id") Long id, Model modelo) {
        Clinica clinica = clinicaDao.findOne(id);
        modelo.addAttribute("titulopes", "Citas de hoy");
        modelo.addAttribute("titulo", "Hola," + clinica.getNombre() + "estas son tus proximas citas");
        modelo.addAttribute("citas", citaDao.listByClinica(clinica));
        return "citas/lista_citas";
    }

    @GetMapping("/citas/usuario/{id}")
    public String listarCitasPorUsuario(@PathVariable("id") Long id, Model modelo) {
        Usuario usuario = usuarioDao.findOne(id);
        modelo.addAttribute("titulopes", "Tus citas");
        modelo.addAttribute("titulo", "Hola, " + usuario.getNombre() + "aquí están tus citas");
        modelo.addAttribute("citas", citaDao.listByUsuario(usuario));
        return "citas/lista_citas";
    }

}
