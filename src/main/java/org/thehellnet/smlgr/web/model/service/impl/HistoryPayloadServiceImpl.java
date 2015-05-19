package org.thehellnet.smlgr.web.model.service.impl;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thehellnet.smlgr.web.model.HistoryPayload;
import org.thehellnet.smlgr.web.model.dao.HistoryPayloadDAO;
import org.thehellnet.smlgr.web.model.service.AbstractServiceImpl;
import org.thehellnet.smlgr.web.model.service.HistoryPayloadService;

import java.util.List;

/**
 * Created by sardylan on 18/05/15.
 */
@Service("HistoryPayloadService")
public class HistoryPayloadServiceImpl extends AbstractServiceImpl<HistoryPayload, HistoryPayloadDAO> implements HistoryPayloadService {
    @Autowired
    @Override
    public void setDao(HistoryPayloadDAO dao) {
        this.dao = dao;
    }


    @Override
    public List<HistoryPayload> getToday() {
        return dao.getToday();
    }

    @Override
    public List<HistoryPayload> getYesterday() {
        return dao.getYesterday();
    }

    @Override
    public List<HistoryPayload> getDay(DateTime day) {
        return dao.getDay(day);
    }

    @Override
    public List<HistoryPayload> getInterval(DateTime startTime, DateTime stopTime) {
        return dao.getInterval(startTime, stopTime);
    }
}
