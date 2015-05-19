package org.thehellnet.smlgr.web.model.dao;

import java.util.List;

/**
 * Created by sardylan on 14/05/15.
 */
public interface IDAO<E> {
    public void persist(E entity);
    public void persistAndFlush(E entity);

    public void refresh(E entity);
    public void refreshAndFlush(E entity);

    public E merge(E entity);
    public E mergeAndFlush(E entity);

    public void remove(long id);
    public void removeAndFlush(long id);

    public E findById(long id);
    public List<E> findAll();
}
