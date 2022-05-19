package es.vetappoint.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.vetappoint.dao.ClinicaDao;
import es.vetappoint.entities.Clinica;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("ClinicaDaoJPA")
public class ClinicaDaoImpl implements ClinicaDao {
    @PersistenceContext
    private EntityManager em;

    public ClinicaDaoImpl() {
    }

    @Transactional(
            readOnly = true
    )
    public List<Clinica> findAll() {
        return this.em.createQuery("from Clinica").getResultList();
    }

    @Transactional(
            readOnly = true
    )
    public Clinica findOne(Long id) {
        return (Clinica) this.em.find(Clinica.class, id);
    }

    @Transactional
    public void save(Clinica clinica) {
        if (clinica.getId() != null && clinica.getId() > 0L) {
            this.em.merge(clinica);
        } else {
            this.em.persist(clinica);
        }

    }

    @Transactional
    public void delete(Long id) {
        this.em.remove(this.findOne(id));
    }
}
