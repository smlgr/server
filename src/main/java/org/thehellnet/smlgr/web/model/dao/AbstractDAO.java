package org.thehellnet.smlgr.web.model.dao;

/**
 * Created by sardylan on 14/05/15.
 */
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public abstract class AbstractDAO<E> implements IDAO<E> {

    protected EntityManager entityManager;
    protected Class<E> clazz;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.entityManager = em;
    }

    public void setClazz(Class<E> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void persist(E entity) {
        entityManager.persist(entity);
    }

    @Override
    public void persistAndFlush(E entity) {
        persist(entity);
        entityManager.flush();
    }

    @Override
    public void refresh(E entity) {
        entityManager.refresh(entity);
    }

    @Override
    public void refreshAndFlush(E entity) {
        refresh(entity);
        entityManager.flush();
    }

    @Override
    public E merge(E entity) {
        return entityManager.merge(entity);
    }

    @Override
    public E mergeAndFlush(E entity) {
        E ret = merge(entity);
        entityManager.flush();
        return ret;
    }

    @Override
    public void remove(long id) {
        entityManager.remove(findById(id));
    }

    @Override
    public void removeAndFlush(long id) {
        remove(id);
        entityManager.flush();
    }

    @Override
    public E findById(long id) {
        return entityManager.find(clazz, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<E> findAll() {
        return entityManager.createQuery("FROM " + clazz.getName()).getResultList();
    }
}
