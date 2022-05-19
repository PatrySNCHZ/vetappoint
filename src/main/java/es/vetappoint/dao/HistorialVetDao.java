package es.vetappoint.dao;

import es.vetappoint.entities.Cita;
import es.vetappoint.entities.HistorialVet;

import java.util.List;

public interface HistorialVetDao {
    List<HistorialVet> findAll();
    HistorialVet findOne(Long id);
    void save(HistorialVet historialVet);
    void delete(Long id);
}
