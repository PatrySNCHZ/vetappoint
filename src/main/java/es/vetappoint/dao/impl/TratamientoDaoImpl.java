package es.vetappoint.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.vetappoint.dao.TratamientoDao;
import es.vetappoint.entities.Tratamiento;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("TratamientoDaoJPA")
public class TratamientoDaoImpl implements TratamientoDao {
    @PersistenceContext
    private EntityManager em;

    public TratamientoDaoImpl() {
    }

    @Transactional(
            readOnly = true
    )
    public List<Tratamiento> findAll() {
        return this.em.createQuery("from Tratamiento").getResultList();
    }

    @Transactional(
            readOnly = true
    )
    public Tratamiento findOne(Long id) {
        return (Tratamiento) this.em.find(Tratamiento.class, id);
    }

    @Transactional
    public void save(Tratamiento tratamiento) {
        if (tratamiento.getIdTratamiento() != null && tratamiento.getIdTratamiento() > 0L) {
            this.em.merge(tratamiento);
        } else {
            this.em.persist(tratamiento);
        }

    }

    @Transactional
    public void delete(Long id) {
        this.em.remove(this.findOne(id));
    }
}
