package es.vetappoint.dao.impl;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.vetappoint.dao.TratamientoDao;
import es.vetappoint.entities.*;
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

    @Override
    public List<Tratamiento> listByMascotaId(Mascota mascota) {
            List<Tratamiento> lista = em.createQuery("from Tratamiento t where t.mascota = :id_mascota")
                    .setParameter("id_mascota", mascota ).getResultList();
            return lista;
    }

    @Override
    public List<Tratamiento> listByHistorial(HistorialVet historial) {
        List<Tratamiento> lista = em.createQuery("from Tratamiento t where t.historialvet = :id_historial")
                .setParameter("id_historial", historial ).getResultList();
        return lista;
    }
}
