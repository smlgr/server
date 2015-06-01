package org.thehellnet.smlgr.web.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thehellnet.smlgr.web.model.Inverter;
import org.thehellnet.smlgr.web.model.dao.InverterDAO;
import org.thehellnet.smlgr.web.model.service.AbstractServiceImpl;
import org.thehellnet.smlgr.web.model.service.InverterService;

/**
 * Created by sardylan on 16/05/15.
 */
@Service("InverterService")
public class InverterServiceImpl extends AbstractServiceImpl<Inverter, InverterDAO> implements InverterService {
    @Autowired
    @Override
    public void setDao(InverterDAO dao) {
        this.dao = dao;
    }

    @Override
    public Inverter findByIdAndToken(long inverterId, String token) {
        return dao.findByIdAndToken(inverterId, token);
    }
}
