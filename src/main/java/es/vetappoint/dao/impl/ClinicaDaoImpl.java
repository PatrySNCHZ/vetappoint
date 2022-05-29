package es.vetappoint.dao.impl;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.vetappoint.dao.ClinicaDao;
import es.vetappoint.entities.Clinica;
import es.vetappoint.entities.Usuario;
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
    public Clinica save(Clinica clinica) {
        if (clinica.getId() != null && clinica.getId() > 0L) {
            em.merge(clinica);
        } else {
            em.persist(clinica);
        }
    return clinica;
    }

    @Transactional
    @Override
    public void delete(Long id) {
        em.remove(this.findOne(id));
    }

    @Override
    public Optional<Clinica> findByEmail(String email) {
        List clin = em.createQuery("from Clinica u WHERE u.email=:email", Clinica.class)
                .setParameter("email",email).getResultList();
        if (clin.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of((Clinica) clin.get(0));
        }
    }
    @Override
    public List<Clinica> buscarPorProvincia(String provincia){
        em.createQuery("select distinct p.provincia from Clinica order by c.provincia").getResultList();
        return null;
    }
    public List<Clinica> buscarPorLocalidad(String localidad){
        em.createQuery("select distinct l.localidad from Clinica order by d.localidad").getResultList();
        return null;
    }
}

