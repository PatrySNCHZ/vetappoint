package es.vetappoint.dao.impl;

import es.vetappoint.dao.MascotaDao;
import es.vetappoint.entities.Mascota;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository("mascotaDAOJPA")
public class MascotaImpl implements MascotaDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly= true)
    @Override
    public List<Mascota> findAll() {
        List<Mascota> lista = em.createQuery("from mascotas").getResultList();
        return lista;
    }

    @Transactional(readOnly = true)
    @Override
    public Mascota findOne(Long id) {
        return em.find(Mascota.class, id);
    }

    @Transactional
    @Override
    public void save(Mascota mascota) {
        if(mascota.getId() != null && mascota.getId() >0) {
            em.merge(mascota);
        }else{
            em.persist(mascota);
        }
    }


    @Transactional
    @Override
    public void delete(Long id) {
        em.remove(findOne(id));

    }
}
