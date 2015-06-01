package org.thehellnet.smlgr.web.model.dao;

import org.joda.time.DateTime;
import org.joda.time.MutableDateTime;
import org.springframework.stereotype.Repository;
import org.thehellnet.smlgr.web.model.DataPayload;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

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
            Query query = entityManager.createQuery("SELECT u FROM DataPayload u WHERE inverter.id = :inverterId ORDER BY dateTime DESC");
            query.setMaxResults(1);
            query.setParameter("inverterId", inverterId);
            return (DataPayload) query.getSingleResult();
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
            Query query = entityManager.createQuery("SELECT u FROM DataPayload u WHERE inverter.id = :inverterId "
                    + "AND dateTime BETWEEN :startTime AND :stopTime "
                    + "ORDER BY dateTime ASC");
            query.setParameter("inverterId", inverterId);
            query.setParameter("startTime", startTime.toDateTime());
            query.setParameter("stopTime", stopTime.toDateTime());
            query.setMaxResults(1);
            return (DataPayload) query.getSingleResult();
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
            Query query = entityManager.createQuery("SELECT u FROM DataPayload u WHERE inverter.id = :inverterId "
                    + "AND dateTime BETWEEN :startTime AND :stopTime "
                    + "ORDER BY dateTime DESC");
            query.setParameter("inverterId", inverterId);
            query.setParameter("startTime", startTime.toDateTime());
            query.setParameter("stopTime", stopTime.toDateTime());
            query.setMaxResults(1);
            return (DataPayload) query.getSingleResult();
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
            Query query = entityManager.createQuery("SELECT u FROM DataPayload u WHERE inverter.id = :inverterId "
                    + "AND dateTime BETWEEN :startTime AND :stopTime "
                    + "ORDER BY u.acPower DESC");
            query.setParameter("inverterId", inverterId);
            query.setParameter("startTime", startTime.toDateTime());
            query.setParameter("stopTime", stopTime.toDateTime());
            query.setMaxResults(1);
            return (DataPayload) query.getSingleResult();
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
            Query query = entityManager.createQuery("SELECT u FROM DataPayload u WHERE inverter.id = :inverterId "
                    + "AND dateTime BETWEEN :startTime AND :stopTime "
                    + "ORDER BY u.dateTime ASC");
            query.setParameter("inverterId", inverterId);
            query.setParameter("startTime", startTime.toDateTime());
            query.setParameter("stopTime", stopTime.toDateTime());
            query.setMaxResults(1);
            return (DataPayload) query.getSingleResult();
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
            Query query = entityManager
                    .createQuery("SELECT u FROM DataPayload u WHERE inverter.id = :inverterId "
                            + "AND dateTime BETWEEN :startTime AND :stopTime "
                            + "ORDER BY u.dateTime DESC");
            query.setParameter("inverterId", inverterId);
            query.setParameter("startTime", startTime.toDateTime());
            query.setParameter("stopTime", stopTime.toDateTime());
            query.setMaxResults(1);
            return (DataPayload) query.getSingleResult();
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
            Query query = entityManager.createQuery("SELECT u FROM DataPayload u WHERE inverter.id = :inverterId "
                    + "AND dateTime BETWEEN :startTime AND :stopTime "
                    + "ORDER BY u.acPower DESC");
            query.setParameter("inverterId", inverterId);
            query.setParameter("startTime", startTime.toDateTime());
            query.setParameter("stopTime", stopTime.toDateTime());
            query.setMaxResults(1);
            return (DataPayload) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<DataPayload> getToday() {
        return getDay(new DateTime());
    }

    public List<DataPayload> getYesterday() {
        return getDay(new DateTime().minusDays(1));
    }

    public List<DataPayload> getDay(DateTime day) {
        MutableDateTime startTime = new MutableDateTime(day);
        MutableDateTime stopTime = new MutableDateTime(startTime);
        startTime.setTime(0, 0, 0, 0);
        stopTime.setTime(23, 59, 59, 999);
        return getInterval(startTime.toDateTime(), stopTime.toDateTime());
    }

    public List<DataPayload> getInterval(DateTime startTime, DateTime stopTime) {
        if (startTime == null || stopTime == null) {
            return null;
        }

        try {
            Query query = entityManager.createQuery("SELECT u FROM DataPayload u WHERE u.dateTime BETWEEN :startTime AND :stopTime");
            query.setParameter("startTime", startTime.toDateTime());
            query.setParameter("stopTime", stopTime.toDateTime());
            return (List<DataPayload>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

}
