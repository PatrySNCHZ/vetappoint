package es.vetappoint.dao.impl;

import es.vetappoint.dao.UsuarioDao;
import es.vetappoint.entities.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("UsuarioDaoJPA")
public class UsuarioDaoImpl implements UsuarioDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> findAll() {
        List<Usuario> lista = em.createQuery("from Usuario").getResultList();

        return lista;
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario findOne(Long id) {
        return em.find(Usuario.class, id);
    }

    @Transactional
    @Override
    public void save(Usuario usuario) {
        if (usuario.getId() != null && usuario.getId() > 0) {
            em.merge(usuario);
        }else {
            em.persist(usuario);
        }
    }

    @Transactional
    @Override
    public void delete(Long id) {
        em.remove(findOne(id));
    }
}
