package es.vetappoint.dao.impl;

import es.vetappoint.dao.OpinionDao;
import es.vetappoint.entities.Opinion;
import es.vetappoint.entities.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("OpinionDao")
public class OpinionDaoImpl implements OpinionDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Opinion> findAll() {
        return em.createQuery("from opiniones").getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public Opinion findOne(Long id) {
        return em.find(Opinion.class, id);
    }

    @Transactional
    @Override
    public void save(Opinion opinion) {
        if (opinion.getId() != null && opinion.getIdUsuario() > 0) {
            em.merge(opinion);
        }else {
            em.persist(opinion);
        }
    }

    @Transactional
    @Override
    public void delete(Long id) {
        em.remove(findOne(id));
    }
}
