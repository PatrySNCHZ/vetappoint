package es.vetappoint.dao;

import es.vetappoint.entities.Mascota;
import es.vetappoint.entities.Tratamiento;
import es.vetappoint.entities.Usuario;

import java.util.List;

public interface TratamientoDao {
    List<Tratamiento> findAll();

    Tratamiento findOne(Long id);

    void save(Tratamiento tratamiento);

    void delete(Long id);
    public List<Tratamiento> listByMascotaId(Mascota mascota);
}
