package es.vetappoint.dao;

import es.vetappoint.entities.Tratamiento;

import java.util.List;

public interface IfxTratamientoDao {
    List<Tratamiento> findAll();

    Tratamiento findOne(Long id);

    void save(Tratamiento tratamiento);

    void delete(Long id);
}
