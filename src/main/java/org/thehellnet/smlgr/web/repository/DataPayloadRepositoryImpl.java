package org.thehellnet.smlgr.web.repository;

import org.joda.time.DateTime;
import org.thehellnet.smlgr.web.model.Inverter;

import javax.persistence.NoResultException;

/**
 * Created by sardylan on 26/12/15.
 */
public class DataPayloadRepositoryImpl extends AbstractRepositoryCustom implements DataPayloadRepositoryCustom {

    @Override
    public DateTime findFirstDateTimeByInverter(Inverter inverter) {
        try {
            return (DateTime) entityManager
                    .createQuery("SELECT d.dateTime " +
                            "FROM DataPayload d " +
                            "WHERE d.inverter = :inverter " +
                            "ORDER BY d.dateTime ASC")
                    .setParameter("inverter", inverter)
                    .setMaxResults(1)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public DateTime findLastDateTimeByInverter(Inverter inverter) {
        try {
            return (DateTime) entityManager
                    .createQuery("SELECT d.dateTime " +
                            "FROM DataPayload d " +
                            "WHERE d.inverter = :inverter " +
                            "ORDER BY d.dateTime DESC")
                    .setParameter("inverter", inverter)
                    .setMaxResults(1)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
