package es.vetappoint.dao;

import es.vetappoint.entities.Usuario;

import java.util.List;

public interface UsuarioDao {
    public List<Usuario> findAll();
    public Usuario findOne(Long id);
    public void save(Usuario usuario);
    public void delete(Long id);
}
