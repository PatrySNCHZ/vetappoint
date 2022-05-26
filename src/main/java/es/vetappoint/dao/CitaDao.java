package es.vetappoint.dao;

import es.vetappoint.entities.Cita;
import es.vetappoint.entities.Clinica;
import es.vetappoint.entities.Opinion;
import es.vetappoint.entities.Usuario;

import java.util.List;

public interface CitaDao {
    List<Cita> findAll();
    Cita findOne(Long id);
    void save(Cita cita);
    void delete(Long id);
    public List<Cita> listByClinica(Clinica clinica);
    public List<Cita> listByUsuario(Usuario usuario);

}
