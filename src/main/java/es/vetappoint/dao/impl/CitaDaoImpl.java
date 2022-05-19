package es.vetappoint.dao.impl;

import es.vetappoint.dao.CitaDao;
import es.vetappoint.dao.UsuarioDao;
import es.vetappoint.entities.Cita;
import es.vetappoint.entities.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("CitaDaoJPA")
public class CitaDaoImpl implements CitaDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Cita> findAll() {
        return em.createQuery("from citas").getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public Cita findOne(Long id) {
        return em.find(Cita.class, id);
    }

    @Transactional
    @Override
    public void save(Cita cita) {
        if (cita.getId() != null && cita.getId() > 0) {
            em.merge(cita);
        } else {
            em.persist(cita);
        }
    }

    @Transactional
    @Override
    public void delete(Long id) {
        em.remove(findOne(id));
    }
}
