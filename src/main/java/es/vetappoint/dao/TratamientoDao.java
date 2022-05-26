package es.vetappoint.dao;

import es.vetappoint.entities.*;

import java.util.List;
import java.util.Optional;

public interface TratamientoDao {
    List<Tratamiento> findAll();

    Tratamiento findOne(Long id);

    void save(Tratamiento tratamiento);

    void delete(Long id);
    public List<Tratamiento> listByMascotaId(Mascota mascota);
    public List<Tratamiento> listByHistorial(HistorialVet historial);
}
