package es.vetappoint.dao;

import es.vetappoint.entities.Cita;
import es.vetappoint.entities.HistorialVet;
import es.vetappoint.entities.Mascota;
import es.vetappoint.entities.Tratamiento;

import java.util.List;

public interface HistorialVetDao {
    List<HistorialVet> findAll();
    HistorialVet findOne(Long id);
    void save(HistorialVet historialVet);
    void delete(Long id);
    public List<HistorialVet> listByMascotaId(Mascota mascota);
}
