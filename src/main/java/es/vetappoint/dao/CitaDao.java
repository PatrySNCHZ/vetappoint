package es.vetappoint.dao;

import es.vetappoint.entities.Cita;
import es.vetappoint.entities.Clinica;

import java.util.List;

public interface CitaDao {
    List<Cita> findAll();
    Cita findOne(Long id);
    void save(Cita cita);
    void delete(Long id);
}
