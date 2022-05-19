package es.vetappoint.dao;

import es.vetappoint.entities.Mascota;

import java.util.List;

public interface MascotaDAO {

    public List<Mascota> findAll();
    public Mascota findOne(Long id);
    public void save(Mascota mascota);
    public void delete(Long id);

}
