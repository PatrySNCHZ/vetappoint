package es.vetappoint.dao;

import es.vetappoint.entities.Mascota;
import es.vetappoint.entities.Usuario;

import java.util.List;

public interface MascotaDao {

    public List<Mascota> findAll();
    public Mascota findOne(Long id);
    public void save(Mascota mascota);
    public void delete(Long id);
    public List<Mascota> listByUserId(Usuario usuario);

}
