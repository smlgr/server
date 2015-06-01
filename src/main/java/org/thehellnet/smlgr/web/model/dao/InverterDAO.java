package org.thehellnet.smlgr.web.model.dao;

import org.springframework.stereotype.Repository;
import org.thehellnet.smlgr.web.model.DataPayload;
import org.thehellnet.smlgr.web.model.Inverter;

import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Created by sardylan on 16/05/15.
 */
@Repository
public class InverterDAO extends AbstractDAO<Inverter> {
    public InverterDAO() {
        setClazz(Inverter.class);
    }

    public Inverter findByIdAndToken(long inverterId, String token) {
        try {
            Query query = entityManager.createQuery("SELECT i FROM Inverter i WHERE i.id = :inverterId AND i.token = :token");
            query.setParameter("inverterId", inverterId);
            query.setParameter("token", token);
            return (Inverter) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
