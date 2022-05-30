package es.vetappoint.controllers;

import es.vetappoint.dao.*;
import es.vetappoint.entities.HistorialVet;
import es.vetappoint.entities.Mascota;
import es.vetappoint.entities.Usuario;
import es.vetappoint.entities.Veterinario;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class HistorialVetController {

    @Autowired
    @Qualifier("HistorialVetDaoJPA")
    private HistorialVetDao historialVetDao;

    @Autowired
    @Qualifier("mascotaDAOJPA")
    private MascotaDao mascotaDAO;

    @Autowired
    @Qualifier("TratamientoDaoJPA")
    private TratamientoDao tratamientoDao;

    @Autowired
    @Qualifier("VeterinarioDaoJPA")
    private VeterinarioDao veterinarioDao;


    @GetMapping("/listahistorialvet")
    public String listaTodas(Model modelo) {
        modelo.addAttribute("titulopest", "HistorialVet");
        modelo.addAttribute("titulo", "Listado de historiales veterinarios");
        modelo.addAttribute("historialVet", historialVetDao.findAll());
        modelo.addAttribute("veterinario",veterinarioDao.findAll());
        modelo.addAttribute("mascota",mascotaDAO.findAll());
        return "lista_historialesvet";
    }

    @GetMapping({"/historialvet/{id}"})
    public String editar(@PathVariable("id") Long id, Map<String, Object> modelo) {
        modelo.put("titulopest", "HistorialVet");
        modelo.put("titulo", "Historiales veterinarios");
        HistorialVet historialVet = null;
        if (id > 0L) {
            historialVet = this.historialVetDao.findOne(id);
            modelo.put("historialVet", historialVet);
            return "form_historialvet";
        } else {
            return "redirect:/listahistorialvet";
        }
    }

    @GetMapping({"/eliminar/historialvet/{id}"})
    public String borrar(@PathVariable("id") Long id, Model modelo) {

        historialVetDao.delete(id);

        return "redirect:/listahistorialvet";
    }

    @GetMapping(value ="/registrar/historialvet")
    public String registro(Model model){
        model.addAttribute("titulo", "Registro Historial");
        model.addAttribute("historialVet", new HistorialVet());
        model.addAttribute("veterinarios",veterinarioDao.findAll());
        model.addAttribute("mascotas",mascotaDAO.findAll());
        return "form_historial";
    }

    @RequestMapping(value ="/guardar/historialvet", method = RequestMethod.POST,  consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String guardar(@RequestBody HistorialForm historialForm, Model model){
        model.addAttribute("veterinarios",veterinarioDao.findAll());
        model.addAttribute("mascotas",mascotaDAO.findAll());
        HistorialVet historialVet = new HistorialVet();
        historialVet.setProcedimiento(historialForm.getProcedimiento());
        historialVet.setMascota(mascotaDAO.findOne(historialForm.getMascota_id()));
        historialVet.setVeterinario(veterinarioDao.findOne(historialForm.getVeterinario_id()));
        historialVetDao.save(historialVet);
        return "redirect:/listahistorialvet";
    }

    @GetMapping("/historialvet/mascota/{id}")
    public String listaHistorialPorMascota(@PathVariable("id") Long id, Model modelo) {
        Mascota mascota = mascotaDAO.findOne(id);
        modelo.addAttribute("titulo", "Historial Veterinario");
        modelo.addAttribute("titulopes", "Historial veterinario de " + mascota.getNombre());
        modelo.addAttribute("historialVet", historialVetDao.listByMascotaId(mascota));
        return "lista_historialesvet";
    }
}

@Data
class HistorialForm {
    private String procedimiento;
    private Long mascota_id;
    private Long veterinario_id;

}
