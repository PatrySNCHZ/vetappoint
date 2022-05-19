package es.vetappoint.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.vetappoint.entities.Clinica;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("ClinicaDaoJPA")
public class ClinicaDaoImpl implements IfxClinicaDao {
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
