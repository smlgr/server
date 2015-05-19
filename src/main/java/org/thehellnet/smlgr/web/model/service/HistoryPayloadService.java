package org.thehellnet.smlgr.web.model.service;

import org.joda.time.DateTime;
import org.thehellnet.smlgr.web.model.HistoryPayload;
import org.thehellnet.smlgr.web.model.dao.IDAO;

import java.util.List;

/**
 * Created by sardylan on 18/05/15.
 */
public interface HistoryPayloadService extends IDAO<HistoryPayload> {
    public List<HistoryPayload> getToday();
    public List<HistoryPayload> getYesterday();
    public List<HistoryPayload> getDay(DateTime day);
    public List<HistoryPayload> getInterval(DateTime startTime, DateTime stopTime);
}
