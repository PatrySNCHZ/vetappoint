package es.vetappoint.dao.impl;

import es.vetappoint.dao.HistorialVetDao;
import es.vetappoint.entities.HistorialVet;
import es.vetappoint.entities.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("HistorialVetDaoJPA")
public class HistorialVetDaoImpl implements HistorialVetDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<HistorialVet> findAll() {
        return em.createQuery("from historial_veterinario").getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public HistorialVet findOne(Long id) {
        return em.find(HistorialVet.class, id);
    }

    @Transactional
    @Override
    public void save(HistorialVet historialVet) {
        if (historialVet.getId() != null && historialVet.getId() > 0) {
            em.merge(historialVet);
        }else {
            em.persist(historialVet);
        }
    }

    @Transactional
    @Override
    public void delete(Long id) {
        em.remove(findOne(id));
    }
}
