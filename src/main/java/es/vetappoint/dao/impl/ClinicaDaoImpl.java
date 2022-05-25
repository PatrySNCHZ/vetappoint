package es.vetappoint.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.vetappoint.dao.ClinicaDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("ClinicaDaoJPA")
public class ClinicaDaoImpl implements ClinicaDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional(
            readOnly = true
    )
    @Override
    public List<Clinica> findAll() {
        List<Clinica> lista = em.createQuery("from Clinica").getResultList();
        return lista;
    }

    @Transactional(
            readOnly = true
    )
    @Override
    public Clinica findOne(Long id) {
        return em.find(Clinica.class, id);
    }

    @Transactional
    @Override
    public void save(Clinica clinica) {
        if (clinica.getId() != null && clinica.getId() > 0L) {
            em.merge(clinica);
        } else {
            em.persist(clinica);
        }

    }

    @Transactional
    @Override
    public void delete(Long id) {
        em.remove(this.findOne(id));
    }
}
