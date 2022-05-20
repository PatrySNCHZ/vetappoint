package es.vetappoint.dao;


import es.vetappoint.entities.Clinica;
import java.util.List;

public interface ClinicaDao {

    List<Clinica> findAll();
    Clinica findOne(Long id);
    void save(Clinica clinica);
    void delete(Long id);
}
