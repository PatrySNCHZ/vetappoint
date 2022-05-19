package es.vetappoint.dao;


import es.vetappoint.entities.Clinica;
import java.util.List;

public interface IfxClinicaDao {
    List<Clinica> findAll();

   Clinica findOne(Long id);

    void save(Clinica usuario);

    void delete(Long id);
}
