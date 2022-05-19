package es.vetappoint.dao.impl;

import es.vetappoint.dao.EspecialidadDao;
import es.vetappoint.entities.Especialidad;
import es.vetappoint.entities.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("EspecialidadDaoJPA")
public class EspecialidadDaoImpl implements EspecialidadDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Especialidad> findAll() {
        return em.createQuery("from especialidades").getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public Especialidad findOne(Long id) {
        return em.find(Especialidad.class, id);
    }

    @Transactional
    @Override
    public void save(Especialidad especialidad) {
        if (especialidad.getId() != null && especialidad.getId() > 0) {
            em.merge(especialidad);
        }else {
            em.persist(especialidad);
        }
    }

    @Transactional
    @Override
    public void delete(Long id) {
        em.remove(findOne(id));
    }
}
