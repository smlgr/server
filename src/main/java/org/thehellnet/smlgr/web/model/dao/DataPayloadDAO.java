package org.thehellnet.smlgr.web.model.dao;

import org.joda.time.DateTime;
import org.joda.time.MutableDateTime;
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

    public DataPayload findLastByInverterId(long inverterId) {
        try {
            return (DataPayload) entityManager
                    .createQuery("SELECT u FROM DataPayload u WHERE inverter.id = :inverterId ORDER BY dateTime DESC")
                    .setParameter("inverterId", inverterId)
                    .setMaxResults(1)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public DataPayload findTodayFirstByInverterId(long inverterId) {
        MutableDateTime startTime = new MutableDateTime();
        MutableDateTime stopTime = new MutableDateTime(startTime);
        startTime.setTime(0, 0, 0, 0);
        stopTime.setTime(23, 59, 59, 999);

        try {
            return (DataPayload) entityManager
                    .createQuery("SELECT u FROM DataPayload u WHERE inverter.id = :inverterId "
                            + "AND dateTime BETWEEN :startTime AND :stopTime "
                            + "ORDER BY dateTime ASC")
                    .setParameter("inverterId", inverterId)
                    .setParameter("startTime", startTime.toDateTime())
                    .setParameter("stopTime", stopTime.toDateTime())
                    .setMaxResults(1)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public DataPayload findTodayLastByInverterId(long inverterId) {
        MutableDateTime startTime = new MutableDateTime();
        MutableDateTime stopTime = new MutableDateTime(startTime);
        startTime.setTime(0, 0, 0, 0);
        stopTime.setTime(23, 59, 59, 999);

        try {
            return (DataPayload) entityManager
                    .createQuery("SELECT u FROM DataPayload u WHERE inverter.id = :inverterId "
                            + "AND dateTime BETWEEN :startTime AND :stopTime "
                            + "ORDER BY dateTime DESC")
                    .setParameter("inverterId", inverterId)
                    .setParameter("startTime", startTime.toDateTime())
                    .setParameter("stopTime", stopTime.toDateTime())
                    .setMaxResults(1)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public DataPayload findTodayMaxByInverterId(long inverterId) {
        MutableDateTime startTime = new MutableDateTime();
        MutableDateTime stopTime = new MutableDateTime(startTime);
        startTime.setTime(0, 0, 0, 0);
        stopTime.setTime(23, 59, 59, 999);

        try {
            return (DataPayload) entityManager
                    .createQuery("SELECT u FROM DataPayload u WHERE inverter.id = :inverterId "
                            + "AND dateTime BETWEEN :startTime AND :stopTime "
                            + "ORDER BY outPower DESC")
                    .setParameter("inverterId", inverterId)
                    .setParameter("startTime", startTime.toDateTime())
                    .setParameter("stopTime", stopTime.toDateTime())
                    .setMaxResults(1)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public DataPayload findYesterdayFirstByInverterId(long inverterId) {
        MutableDateTime startTime = new MutableDateTime();
        startTime.addDays(-1);
        MutableDateTime stopTime = new MutableDateTime(startTime);
        startTime.setTime(0, 0, 0, 0);
        stopTime.setTime(23, 59, 59, 999);

        try {
            return (DataPayload) entityManager
                    .createQuery("SELECT u FROM DataPayload u WHERE inverter.id = :inverterId "
                            + "AND dateTime BETWEEN :startTime AND :stopTime "
                            + "ORDER BY dateTime ASC")
                    .setParameter("inverterId", inverterId)
                    .setParameter("startTime", startTime.toDateTime())
                    .setParameter("stopTime", stopTime.toDateTime())
                    .setMaxResults(1)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public DataPayload findYesterdayLastByInverterId(long inverterId) {
        MutableDateTime startTime = new MutableDateTime();
        startTime.addDays(-1);
        MutableDateTime stopTime = new MutableDateTime(startTime);
        startTime.setTime(0, 0, 0, 0);
        stopTime.setTime(23, 59, 59, 999);

        try {
            return (DataPayload) entityManager
                    .createQuery("SELECT u FROM DataPayload u WHERE inverter.id = :inverterId "
                            + "AND dateTime BETWEEN :startTime AND :stopTime "
                            + "ORDER BY dateTime DESC")
                    .setParameter("inverterId", inverterId)
                    .setParameter("startTime", startTime.toDateTime())
                    .setParameter("stopTime", stopTime.toDateTime())
                    .setMaxResults(1)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public DataPayload findYesterdayMaxByInverterId(long inverterId) {
        MutableDateTime startTime = new MutableDateTime();
        startTime.addDays(-1);
        MutableDateTime stopTime = new MutableDateTime(startTime);
        startTime.setTime(0, 0, 0, 0);
        stopTime.setTime(23, 59, 59, 999);

        try {
            return (DataPayload) entityManager
                    .createQuery("SELECT u FROM DataPayload u WHERE inverter.id = :inverterId "
                            + "AND dateTime BETWEEN :startTime AND :stopTime "
                            + "ORDER BY outPower DESC")
                    .setParameter("inverterId", inverterId)
                    .setParameter("startTime", startTime.toDateTime())
                    .setParameter("stopTime", stopTime.toDateTime())
                    .setMaxResults(1)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
