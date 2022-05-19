package es.vetappoint.dao;

import es.vetappoint.entities.Opinion;
import es.vetappoint.entities.Usuario;

import java.util.List;

public interface OpinionDao {
    public List<Opinion> findAll();
    public Opinion findOne(Long id);
    public void save(Opinion opinion);
    public void delete(Long id);
}
