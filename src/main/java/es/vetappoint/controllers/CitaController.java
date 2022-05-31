package es.vetappoint.controllers;

import es.vetappoint.dao.CitaDao;
import es.vetappoint.dao.ClinicaDao;
import es.vetappoint.dao.UsuarioDao;
import es.vetappoint.entities.Cita;
import es.vetappoint.entities.Clinica;
import es.vetappoint.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
            return "redirect:/listacitas";
        }
    }

    @GetMapping({"/eliminar/cita/{id}"})
    public String borrar(@PathVariable("id") Long id, Model modelo) {

        citaDao.delete(id);

        return "redirect:/lista_citas";
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

    @GetMapping("/nuevacita")
    public String nuevacita( Model modelo) {
        Cita nuevacita = new Cita();
        modelo.addAttribute("titulopes", "Nueva cita");
        modelo.addAttribute("titulo", "Crear nueva cita");
        modelo.addAttribute("citas", nuevacita);
        modelo.addAttribute("provincias", clinicaDao.listaProvincias());
        modelo.addAttribute("localidades", clinicaDao.listarLocalidades());

        return "citas/solicitar_cita";

    }

    @PostMapping(value ="/guardar/cita")
    public String guardar(@RequestParam("fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fecha, Cita cita, Model model){




        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String fechaF = sdf1.format(fecha);


        cita.setFecha(LocalDate.parse(fechaF));

        citaDao.save(cita);
        return "redirect:/listacitas";
    }



    @RequestScope
    @GetMapping("/filtraporprovincia")
    public @ResponseBody
    List<String> filtrarPorProvincia(@RequestParam("provincia") String prov) {
            List<String> localidades = clinicaDao.buscarPorProvincia(prov);
        return localidades;
    }

    @RequestScope
    @GetMapping("/filtraporlocalidad")
    public @ResponseBody List<Clinica> filtrarPorLocalidad(@RequestParam("provincia") String prov, @RequestParam("localidad") String localidad) {
        List<Clinica> clinicas = clinicaDao.buscarPorLocalidad(prov, localidad);
        return clinicas;
    }
}
