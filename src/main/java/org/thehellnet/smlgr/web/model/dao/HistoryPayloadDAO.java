package org.thehellnet.smlgr.web.model.dao;

import org.joda.time.DateTime;
import org.joda.time.MutableDateTime;
import org.springframework.stereotype.Repository;
import org.thehellnet.smlgr.web.model.HistoryPayload;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by sardylan on 18/05/15.
 */
@Repository
public class HistoryPayloadDAO extends AbstractDAO<HistoryPayload> {
    public HistoryPayloadDAO() {
        setClazz(HistoryPayload.class);
    }

    public List<HistoryPayload> getToday() {
        return getDay(new DateTime());
    }

    public List<HistoryPayload> getYesterday() {
        return getDay(new DateTime().minusDays(1));
    }

    public List<HistoryPayload> getDay(DateTime day) {
        MutableDateTime startTime = new MutableDateTime(day);
        MutableDateTime stopTime = new MutableDateTime(startTime);
        startTime.setTime(0, 0, 0, 0);
        stopTime.setTime(23, 59, 59, 999);
        return getInterval(startTime.toDateTime(), stopTime.toDateTime());
    }

    public List<HistoryPayload> getInterval(DateTime startTime, DateTime stopTime) {
        if (startTime == null || stopTime == null) {
            return null;
        }

        try {
            Query query = entityManager.createQuery("SELECT h FROM HistoryPayload h WHERE h.whenquery BETWEEN :startTime AND :stopTime");
            query.setParameter("startTime", startTime.toDateTime());
            query.setParameter("stopTime", stopTime.toDateTime());
            return (List<HistoryPayload>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
