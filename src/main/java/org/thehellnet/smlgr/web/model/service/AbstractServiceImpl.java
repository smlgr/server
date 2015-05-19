package org.thehellnet.smlgr.web.model.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thehellnet.smlgr.web.model.dao.AbstractDAO;
import org.thehellnet.smlgr.web.model.dao.IDAO;

import java.util.List;

/**
 * Created by sardylan on 16/05/15.
 */
public abstract class AbstractServiceImpl<E, D extends AbstractDAO<E>> implements IDAO<E> {

    protected D dao;

    public void setDao(D dao) {
        this.dao = dao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void persist(E entity) {
        dao.persist(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void persistAndFlush(E entity) {
        dao.persistAndFlush(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public void refresh(E entity) {
        dao.refresh(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public void refreshAndFlush(E entity) {
        dao.refreshAndFlush(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public E merge(E entity) {
        return dao.merge(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public E mergeAndFlush(E entity) {
        return dao.mergeAndFlush(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void remove(long id) {
        dao.remove(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void removeAndFlush(long id) {
        dao.removeAndFlush(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public E findById(long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<E> findAll() {
        return dao.findAll();
    }
}
