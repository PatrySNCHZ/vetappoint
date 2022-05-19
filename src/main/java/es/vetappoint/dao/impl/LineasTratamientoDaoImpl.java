package es.vetappoint.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.vetappoint.dao.LineasTratamientoDao;
import es.vetappoint.entities.LineasTratamiento;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("LineasTratamientoDaoJPA")
public class LineasTratamientoDaoImpl implements LineasTratamientoDao {
    @PersistenceContext
    private EntityManager em;

    public LineasTratamientoDaoImpl() {
    }

    @Transactional(
            readOnly = true
    )
    public List<LineasTratamiento> findAll() {
        return this.em.createQuery("from LineasTratamiento").getResultList();
    }

    @Transactional(
            readOnly = true
    )
    public LineasTratamiento findOne(Long id) {
        return (LineasTratamiento) this.em.find(LineasTratamiento.class, id);
    }

    @Transactional
    public void save(LineasTratamiento lineas_tratamiento) {
        if (lineas_tratamiento.getId_lineatratamiento() != null && lineas_tratamiento.getId_lineatratamiento() > 0L) {
            this.em.merge(lineas_tratamiento);
        } else {
            this.em.persist(lineas_tratamiento);
        }

    }

    @Transactional
    public void delete(Long id) {
        this.em.remove(this.findOne(id));
    }
}
