package es.vetappoint.dao;

import es.vetappoint.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioDao {
    public List<Usuario> findAll();
    public Usuario findOne(Long id);
    public void save(Usuario usuario);
    public void delete(Long id);
    public Optional<Usuario> findByEmail(String email);
}
