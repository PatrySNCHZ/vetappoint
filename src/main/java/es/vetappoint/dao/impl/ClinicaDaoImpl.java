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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;

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
    public List<String> listaProvincias() {
        List<String> lista = em.createQuery("select distinct c.provincia from Clinica c order by c.provincia").getResultList();
        return lista;
    }

    @Override
    public List<String> listarLocalidades() {
        List<String> lista = em.createQuery("select distinct c.localidad from Clinica c order by c.localidad").getResultList();
        return lista;
    }

    @Override
    public List<String> buscarPorProvincia(String provincia) {
        List<String> localidades = em.createQuery("select c.localidad from Clinica c where c.provincia = :prov")
                .setParameter("prov", provincia)
                .getResultList();
        return localidades;
    }

    @Override
    public List<Clinica> buscarPorLocalidad(String provincia, String localidad) {
        List<Clinica> clinicas = em.createQuery("from Clinica c where c.provincia = :prov and c.localidad = :loc")
                .setParameter("prov", provincia)
                .setParameter("loc", localidad)
                .getResultList();
        return clinicas;
    }
}

