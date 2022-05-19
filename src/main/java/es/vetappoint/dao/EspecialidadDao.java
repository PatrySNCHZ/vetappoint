package es.vetappoint.dao;

import es.vetappoint.entities.Especialidad;
import es.vetappoint.entities.Usuario;

import java.util.List;

public interface EspecialidadDao {
    public List<Especialidad> findAll();
    public Especialidad findOne(Long id);
    public void save(Especialidad especialidad);
    public void delete(Long id);
}
