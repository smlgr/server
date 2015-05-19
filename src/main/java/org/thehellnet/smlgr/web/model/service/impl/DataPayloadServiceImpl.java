package org.thehellnet.smlgr.web.model.service.impl;

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
    public DataPayload findLast() {
        return dao.findLast();
    }
}
