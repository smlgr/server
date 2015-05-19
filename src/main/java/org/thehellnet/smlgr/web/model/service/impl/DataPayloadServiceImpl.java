package org.thehellnet.smlgr.web.model.service.impl;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thehellnet.smlgr.web.model.DataPayload;
import org.thehellnet.smlgr.web.model.dao.DataPayloadDAO;
import org.thehellnet.smlgr.web.model.service.AbstractServiceImpl;
import org.thehellnet.smlgr.web.model.service.DataPayloadService;

import java.util.List;

/**
 * Created by sardylan on 16/05/15.
 */
@Service("DataPayloadService")
public class DataPayloadServiceImpl extends AbstractServiceImpl<DataPayload, DataPayloadDAO> implements DataPayloadService {
    @Autowired
    @Override
    public void setDao(DataPayloadDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public DataPayload findLastByInverterId(long inverterId) {
        return dao.findLastByInverterId(inverterId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public DataPayload findTodayFirstByInverterId(long inverterId) {
        return dao.findTodayFirstByInverterId(inverterId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public DataPayload findTodayLastByInverterId(long inverterId) {
        return dao.findTodayLastByInverterId(inverterId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public DataPayload findTodayMaxByInverterId(long inverterId) {
        return dao.findTodayMaxByInverterId(inverterId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public DataPayload findYesterdayFirstByInverterId(long inverterId) {
        return dao.findYesterdayFirstByInverterId(inverterId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public DataPayload findYesterdayLastByInverterId(long inverterId) {
        return dao.findYesterdayLastByInverterId(inverterId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public DataPayload findYesterdayMaxByInverterId(long inverterId) {
        return dao.findYesterdayMaxByInverterId(inverterId);
    }
}
