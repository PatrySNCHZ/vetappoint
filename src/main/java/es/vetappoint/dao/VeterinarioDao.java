package es.vetappoint.dao;


import es.vetappoint.entities.Veterinario;

import java.util.List;

public interface VeterinarioDao {
    public List<Veterinario> findAll();
    public Veterinario findOne(Long id);
    public void save(Veterinario veterinario);
    public void delete(Long id);
}
