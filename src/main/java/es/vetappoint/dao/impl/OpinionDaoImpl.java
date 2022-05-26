package es.vetappoint.dao.impl;

import es.vetappoint.dao.OpinionDao;
import es.vetappoint.entities.Clinica;
import es.vetappoint.entities.Opinion;
import es.vetappoint.entities.Tratamiento;
import es.vetappoint.entities.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("OpinionDaoJPA")
public class OpinionDaoImpl implements OpinionDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Opinion> findAll() {
        return em.createQuery("from Opinion").getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public Opinion findOne(Long id) {
        return em.find(Opinion.class, id);
    }

    @Transactional
    @Override
    public void save(Opinion opinion) {
        if (opinion.getId() != null && opinion.getId_usuario().getId() > 0) {
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

    @Override
    public List<Opinion> listByClinica(Clinica clinica) {
        List<Opinion> lista = em.createQuery("from Opinion o where o.id_clinica = :id_clinica")
                .setParameter("id_clinica", clinica ).getResultList();
        return lista;
    }

    @Override
    public List<Opinion> listByUsuario(Usuario usuario) {
        List<Opinion> lista = em.createQuery("from Opinion o where o.id_usuario = :id_usuario")
                .setParameter("id_usuario", usuario ).getResultList();
        return lista;
    }
}
