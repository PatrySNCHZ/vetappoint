package es.vetappoint.dao;


import es.vetappoint.entities.Clinica;
import es.vetappoint.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface ClinicaDao {

    List<Clinica> findAll();
    Clinica findOne(Long id);
    Clinica save(Clinica clinica);
    void delete(Long id);
    public Optional<Clinica> findByEmail(String email);
    List<String> listaProvincias();
    List<String> listarLocalidades();
    List<String> buscarPorProvincia(String provincia);
    List<Clinica> buscarPorLocalidad(String provincia, String localidad);

//      List<Clinica> filtrarPorLocalidad(String provincia, String localidad);
//      List<Clinica> buscarPorProvincia(String provincia);
//      List<Clinica> buscarPorLocalidad(String localidad);


}
