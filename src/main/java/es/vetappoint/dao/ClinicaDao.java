package es.vetappoint.dao;


import es.vetappoint.entities.Clinica;
import es.vetappoint.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface ClinicaDao {

    List<Clinica> findAll();
    Clinica findOne(Long id);
    void save(Clinica clinica);
    void delete(Long id);
    public Optional<Clinica> findByEmail(String email);
    List<Clinica> listaProvincias();
    List<Clinica> buscarPorProvincia(String provincia);
    List<Clinica> buscarPorLocalidad(String localidad);

}
