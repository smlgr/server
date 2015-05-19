package org.thehellnet.smlgr.web.model.dao;

import org.springframework.stereotype.Repository;
import org.thehellnet.smlgr.web.model.DataPayload;

import javax.persistence.NoResultException;

/**
 * Created by sardylan on 14/05/15.
 */
@Repository
public class DataPayloadDAO extends AbstractDAO<DataPayload> {
    public DataPayloadDAO() {
        setClazz(DataPayload.class);
    }

    public DataPayload findLast() {
        try {
            return (DataPayload) entityManager
                    .createQuery("SELECT u FROM DataPayload u ORDER BY dateTime DESC")
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
