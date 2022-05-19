package es.vetappoint.dao.impl;

import es.vetappoint.dao.VeterinarioDao;
import es.vetappoint.entities.Veterinario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("VeterinarioDaoJPA")
public class VeterinarioDaoImpl implements VeterinarioDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Veterinario> findAll() {
        return em.createQuery("from veterinarios").getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public Veterinario findOne(Long id) {
        return em.find(Veterinario.class, id);
    }

    @Transactional
    @Override
    public void save(Veterinario veterinario) {
        if (veterinario.getId() != null && veterinario.getId() > 0) {
            em.merge(veterinario);
        }else {
            em.persist(veterinario);
        }
    }

    @Transactional
    @Override
    public void delete(Long id) {
        em.remove(findOne(id));
    }
}
