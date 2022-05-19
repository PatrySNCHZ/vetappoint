package es.vetappoint.dao;

import es.vetappoint.entities.LineasTratamiento;

import java.util.List;

public interface IfxLineasTratamientoDao {
    List<LineasTratamiento> findAll();

    LineasTratamiento findOne(Long id);

    void save(LineasTratamiento lineas_tratamiento);

    void delete(Long id);
}
